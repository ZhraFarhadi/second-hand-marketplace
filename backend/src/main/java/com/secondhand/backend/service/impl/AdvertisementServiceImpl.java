package com.secondhand.backend.service.impl;
import com.secondhand.backend.service.interfaces.CurrentUserService;
import com.secondhand.backend.dto.advertisement.request.*;

import com.secondhand.backend.dto.advertisement.response.*;

import com.secondhand.backend.entity.*;
import com.secondhand.backend.enums.AdvertisementStatus;
import com.secondhand.backend.exception.*;

import com.secondhand.backend.mapper.interfaces.AdvertisementMapper;
import com.secondhand.backend.repository.*;
import com.secondhand.backend.service.interfaces.AdvertisementService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final CategoryRepository categoryRepository;
    private final CityRepository cityRepository;
    private final CategoryAttributeRepository categoryAttributeRepository;

    private final AdvertisementMapper advertisementMapper;
    private final CurrentUserService currentUserService;

    /**
     * create()
     *     │
     *     ├── getCurrentUser()
     *     ├── getCategory()
     *     ├── getCity()
     *     ├── validateImages()
     *     ├── validateAttributes()
     *     ├── buildAdvertisement()
     *     ├── buildImages()
     *     ├── buildAttributes()
     *     └── save()
     */

    @Override
    public AdvertisementDetailsResponse create(CreateAdvertisementRequest request) {

        User seller = currentUserService.getCurrentUser();

        Category category = getCategory(request.getCategoryId());

        City city = getCity(request.getCityId());

        validateImages(request.getImages());

        Map<Long, CategoryAttribute> attributeMap =
                validateAttributes(
                        category,
                        request.getAttributes()
                );

        Advertisement advertisement =
                buildAdvertisement(request, seller, category, city);

        buildImages(advertisement, request.getImages());

        buildAttributes(
                advertisement,
                request.getAttributes(),
                attributeMap
        );

        Advertisement savedAdvertisement =
                advertisementRepository.save(advertisement);

        return advertisementMapper.toDetailsResponse(savedAdvertisement);


    }


    @Override
    public AdvertisementDetailsResponse update(
            Long advertisementId,
            UpdateAdvertisementRequest request
    ) {

        User currentUser = currentUserService.getCurrentUser();

        Advertisement advertisement =
                getExistingAdvertisement(advertisementId);

        validateAdvertisementOwner(
                advertisement,
                currentUser
        );

        validateAdvertisementCanBeUpdated(advertisement);

        Category category = getCategory(request.getCategoryId());

        City city = getCity(request.getCityId());

        validateImages(request.getImages());

        Map<Long, CategoryAttribute> attributeMap =
                validateAttributes(
                        category,
                        request.getAttributes()
                );

        boolean requiresReview = hasAdvertisementMajorChanges(
                advertisement,
                request
        );

        updateAdvertisement(
                advertisement,
                request,
                category,
                city
        );

        replaceImages(
                advertisement,
                request.getImages()
        );

        replaceAttributes(
                advertisement,
                request.getAttributes(),
                attributeMap
        );

        if (requiresReview
                && advertisement.getStatus() != AdvertisementStatus.PENDING) {

            advertisement.setStatus(AdvertisementStatus.PENDING);

        }

        Advertisement updatedAdvertisement =
                advertisementRepository.save(advertisement);

        return advertisementMapper.toDetailsResponse(
                updatedAdvertisement
        );
    }

    @Override
    public void delete(Long advertisementId) {

        User currentUser = currentUserService.getCurrentUser();

        Advertisement advertisement =
                getExistingAdvertisement(advertisementId);

        validateAdvertisementOwner(
                advertisement,
                currentUser
        );

        validateAdvertisementCanBeDeleted(
                advertisement
        );

        advertisement.setDeletedAt(LocalDateTime.now());

        advertisementRepository.save(advertisement);

    }

    @Override
    public AdvertisementDetailsResponse markAsSold(Long advertisementId) {

        User currentUser =currentUserService.getCurrentUser();

        Advertisement advertisement =
                getExistingAdvertisement(advertisementId);

        validateAdvertisementOwner(
                advertisement,
                currentUser
        );

        validateAdvertisementActive(advertisement);

        advertisement.setStatus(AdvertisementStatus.SOLD);

        Advertisement savedAdvertisement =
                advertisementRepository.save(advertisement);

        return advertisementMapper.toDetailsResponse(savedAdvertisement);

    }

    @Override
    @Transactional
    public AdvertisementDetailsResponse getAdvertisementDetails(
            Long advertisementId
    ) {

        Advertisement advertisement =
                getExistingAdvertisement(advertisementId);

        User authenticatedUser =
                currentUserService.getCurrentUserOrNull();

        validateAdvertisementVisibility(
                advertisement,
                authenticatedUser
        );

        return advertisementMapper.toDetailsResponse(advertisement);

    }

    @Override
    @Transactional
    public Page<MyAdvertisementSummaryResponse> getMyAdvertisements(
            Pageable pageable
    ) {

        User currentUser = currentUserService.getCurrentUser();

        Page<Advertisement> advertisements =
                advertisementRepository.findBySellerAndDeletedAtIsNullOrderByCreatedAtDesc(
                        currentUser,
                        pageable
                );

        return advertisements.map(
                advertisementMapper::toMySummaryResponse
        );

    }

    @Override
    @Transactional
    public Page<AdvertisementSummaryResponse> getAdvertisements(
            Pageable pageable
    ) {

        Page<Advertisement> advertisements =
                advertisementRepository
                        .findByStatusAndDeletedAtIsNullOrderByCreatedAtDesc(
                                AdvertisementStatus.ACTIVE,
                                pageable
                        );

        return advertisements.map(
                advertisementMapper::toSummaryResponse
        );

    }

    private Category getCategory(Long categoryId) {

        Category category =
                categoryRepository.findById(categoryId)
                        .orElseThrow(() ->
                                new BusinessException(
                                        ErrorCode.CATEGORY_NOT_FOUND
                                ));

        validateCategoryIsLeaf(category);

        return category;
    }

    private City getCity(Long cityId) {

        return cityRepository.findById(cityId)
                .orElseThrow(() ->
                             new BusinessException(
                                    ErrorCode.CITY_NOT_FOUND
                            ));
    }

    private Advertisement buildAdvertisement(
            CreateAdvertisementRequest request,
            User seller,
            Category category,
            City city
    ) {

        Advertisement advertisement = new Advertisement();

        advertisement.setTitle(request.getTitle().trim());
        advertisement.setDescription(request.getDescription().trim());
        advertisement.setPrice(request.getPrice());

        advertisement.setSeller(seller);
        advertisement.setCategory(category);
        advertisement.setCity(city);

        advertisement.setStatus(AdvertisementStatus.PENDING);

        return advertisement;
    }

    private void buildImages(
            Advertisement advertisement,
            List<AdvertisementImageRequest> images
    ) {

        int order = 1;

        for (AdvertisementImageRequest request : images) {

            AdvertisementImage image = new AdvertisementImage();

            image.setImageUrl(request.getImageUrl().trim());

            image.setPrimary(request.isPrimary());

            image.setDisplayOrder(order++);

            advertisement.addImage(image);
        }

    }

    private void validateImages(
            List<AdvertisementImageRequest> images
    ) {

        long primaryCount = images.stream()
                .filter(AdvertisementImageRequest::isPrimary)
                .count();

        if (primaryCount != 1) {

            throw new BusinessException(
                    ErrorCode.INVALID_PRIMARY_IMAGE
            );

        }

    }

    private Map<Long, CategoryAttribute> validateAttributes(
            Category category,
            List<AdvertisementAttributeRequest> requestAttributes
    ) {

        if (requestAttributes == null) {
            requestAttributes = Collections.emptyList();
        }

        List<CategoryAttribute> categoryAttributes =
                categoryAttributeRepository.findByCategoryOrderByNameAsc(category);

        Map<Long, CategoryAttribute> categoryAttributeMap =
                categoryAttributes.stream()
                        .collect(Collectors.toMap(
                                CategoryAttribute::getId,
                                Function.identity()
                        ));

        Set<Long> usedAttributeIds = new HashSet<>();

        for (AdvertisementAttributeRequest request : requestAttributes) {

            CategoryAttribute categoryAttribute =
                    categoryAttributeMap.get(request.getCategoryAttributeId());

            if (categoryAttribute == null) {
                throw new BusinessException(
                        ErrorCode.INVALID_ATTRIBUTE
                );
            }

            if (!usedAttributeIds.add(request.getCategoryAttributeId())) {
                throw new BusinessException(
                        ErrorCode.DUPLICATE_ATTRIBUTE
                );
            }

            validateAttributeValue(
                    categoryAttribute,
                    request.getValue().trim()
            );
        }

        Set<Long> requestAttributeIds = requestAttributes.stream()
                .map(AdvertisementAttributeRequest::getCategoryAttributeId)
                .collect(Collectors.toSet());

        for (CategoryAttribute attribute : categoryAttributes) {

            if (attribute.isRequired()
                    && !requestAttributeIds.contains(attribute.getId())) {

                throw new BusinessException(
                        ErrorCode.VALIDATION_ERROR,
                        attribute.getName() + " is required."
                );
            }
        }

        return categoryAttributeMap;
    }
    private void validateAttributeValue(
            CategoryAttribute attribute,
            String value
    ) {

        switch (attribute.getDataType()) {

            case TEXT -> {
                // DTO validation
            }

            case NUMBER -> {

                try {
                    new BigDecimal(value);
                } catch (NumberFormatException ex) {

                    throw new BusinessException(
                            ErrorCode.INVALID_ATTRIBUTE_VALUE,
                            attribute.getName() + " must be a number."
                    );
                }

            }

            case BOOLEAN -> {

                if (!value.equalsIgnoreCase("true")
                        && !value.equalsIgnoreCase("false")) {

                    throw new BusinessException(
                            ErrorCode.INVALID_ATTRIBUTE_VALUE,
                            attribute.getName() + " must be true or false."
                    );
                }

            }

            case DATE -> {

                try {
                    LocalDate.parse(value);
                } catch (DateTimeParseException ex) {

                    throw new BusinessException(
                            ErrorCode.INVALID_ATTRIBUTE_VALUE,
                            attribute.getName() + " has an invalid date."
                    );
                }

            }

        }

    }

    private void buildAttributes(
            Advertisement advertisement,
            List<AdvertisementAttributeRequest> requestAttributes,
            Map<Long, CategoryAttribute> attributeMap
    ) {

        if (requestAttributes == null || requestAttributes.isEmpty()) {
            return;
        }

        for (AdvertisementAttributeRequest request : requestAttributes) {

            CategoryAttribute categoryAttribute =
                    attributeMap.get(request.getCategoryAttributeId());

            AdvertisementAttribute attribute =
                    new AdvertisementAttribute();

            attribute.setCategoryAttribute(categoryAttribute);
            attribute.setValue(request.getValue().trim());

            advertisement.addAttribute(attribute);
        }

    }


    private Advertisement getExistingAdvertisement(Long id) {

        return advertisementRepository
                .findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.ADVERTISEMENT_NOT_FOUND
                        ));
    }

    private void validateAdvertisementOwner(
            Advertisement advertisement,
            User currentUser
    ) {

        if (!advertisement.getSeller().getId()
                .equals(currentUser.getId())) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_NOT_OWNER
            );
        }

    }

    private void validateAdvertisementCanBeUpdated(
            Advertisement advertisement
    ) {

        if (advertisement.getStatus() == AdvertisementStatus.SOLD) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_CANNOT_BE_UPDATED
            );

        }

    }

    private void updateAdvertisement(
            Advertisement advertisement,
            UpdateAdvertisementRequest request,
            Category category,
            City city
    ) {

        advertisement.setTitle(request.getTitle().trim());

        advertisement.setDescription(
                request.getDescription().trim()
        );

        advertisement.setPrice(request.getPrice());

        advertisement.setCategory(category);

        advertisement.setCity(city);

    }

    private void replaceImages(
            Advertisement advertisement,
            List<AdvertisementImageRequest> images
    ) {

        advertisement.getImages().clear();

        buildImages(
                advertisement,
                images
        );

    }

    private void replaceAttributes(
            Advertisement advertisement,
            List<AdvertisementAttributeRequest> requestAttributes,
            Map<Long, CategoryAttribute> attributeMap
    ) {

        advertisement.getAttributes().clear();

        buildAttributes(
                advertisement,
                requestAttributes,
                attributeMap
        );

    }

    private void validateAdvertisementActive(
            Advertisement advertisement
    ) {

        if (advertisement.getStatus() != AdvertisementStatus.ACTIVE) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_NOT_ACTIVE
            );

        }

    }

    private void validateAdvertisementVisibility(
            Advertisement advertisement,
            User authenticatedUser
    ) {

        if (advertisement.getStatus() == AdvertisementStatus.ACTIVE) {
            return;
        }

        if (authenticatedUser != null
                && advertisement.getSeller().getId()
                .equals(authenticatedUser.getId())) {

            return;
        }

        throw new BusinessException(
                ErrorCode.ADVERTISEMENT_NOT_FOUND
        );

    }

    private boolean hasAdvertisementMajorChanges(
            Advertisement advertisement,
            UpdateAdvertisementRequest request
    ) {


        if (!advertisement.getCategory().getId()
                .equals(request.getCategoryId())) {
            return true;
        }

        if (!advertisement.getCity().getId()
                .equals(request.getCityId())) {
            return true;
        }

        if (haveImagesChanged(
                advertisement,
                request.getImages())) {
            return true;
        }

        return haveAttributesChanged(
                advertisement,
                request.getAttributes()
        );

    }

    private boolean haveImagesChanged(
            Advertisement advertisement,
            List<AdvertisementImageRequest> requestImages
    ) {

        List<AdvertisementImage> currentImages =
                advertisement.getImages();

        if (currentImages.size() != requestImages.size()) {
            return true;
        }

        for (int i = 0; i < currentImages.size(); i++) {

            AdvertisementImage current =
                    currentImages.get(i);

            AdvertisementImageRequest request =
                    requestImages.get(i);

            if (!current.getImageUrl().equals(request.getImageUrl().trim())) {
                return true;
            }

            if (current.isPrimary() != request.isPrimary()) {
                return true;
            }

        }

        return false;

    }


    private boolean haveAttributesChanged(
            Advertisement advertisement,
            List<AdvertisementAttributeRequest> requestAttributes
    ) {

        if (requestAttributes == null) {
            requestAttributes = Collections.emptyList();
        }

        List<AdvertisementAttribute> currentAttributes =
                advertisement.getAttributes();

        if (currentAttributes.size() != requestAttributes.size()) {
            return true;
        }

        Map<Long, String> currentValues =
                currentAttributes.stream()
                        .collect(Collectors.toMap(
                                attribute -> attribute
                                        .getCategoryAttribute()
                                        .getId(),
                                AdvertisementAttribute::getValue
                        ));

        for (AdvertisementAttributeRequest request : requestAttributes) {

            String currentValue =
                    currentValues.get(request.getCategoryAttributeId());

            if (currentValue == null) {
                return true;
            }

            if (!currentValue.equals(request.getValue().trim())) {
                return true;
            }

        }

        return false;

    }


    private void validateAdvertisementCanBeDeleted(
            Advertisement advertisement
    ) {

        if (advertisement.getStatus() == AdvertisementStatus.SOLD) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_CANNOT_BE_DELETED
            );

        }

    }

    private void validateCategoryIsLeaf(
            Category category
    ) {

        if (categoryRepository.existsByParent(category)) {

            throw new BusinessException(
                    ErrorCode.CATEGORY_IS_NOT_LEAF
            );

        }

    }



}
