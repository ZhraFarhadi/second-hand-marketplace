package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.category.request.CreateCategoryAttributeRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryAttributeRequest;

import com.secondhand.backend.dto.category.response.CategoryAttributeResponse;
import com.secondhand.backend.entity.Category;
import com.secondhand.backend.entity.CategoryAttribute;
import com.secondhand.backend.entity.CategoryAttributeOption;
import com.secondhand.backend.enums.AttributeDataType;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.CategoryAttributeMapper;
import com.secondhand.backend.repository.AdvertisementAttributeRepository;
import com.secondhand.backend.repository.CategoryAttributeOptionRepository;
import com.secondhand.backend.repository.CategoryAttributeRepository;
import com.secondhand.backend.repository.CategoryRepository;
import com.secondhand.backend.service.interfaces.CategoryAttributeService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryAttributeServiceImpl
        implements CategoryAttributeService {

    private final CategoryRepository categoryRepository;

    private final CategoryAttributeRepository
            categoryAttributeRepository;

    private final AdvertisementAttributeRepository
            advertisementAttributeRepository;

    private final CategoryAttributeMapper
            categoryAttributeMapper;

    private final CategoryAttributeOptionRepository
            categoryAttributeOptionRepository;


    @Override
    public CategoryAttributeResponse create(
            Long categoryId,
            CreateCategoryAttributeRequest request
    ) {

        Category category =
                getCategoryOrThrow(categoryId);

        validateCategoryIsLeaf(category);

        String attributeName =
                normalizeAttributeName(request.getName());

        validateAttributeNameUnique(
                category,
                attributeName
        );

        validateSelectAttribute(

                request.getDataType(),

                request.getOptions()

        );

        CategoryAttribute attribute =
                buildAttribute(
                        category,
                        attributeName,
                        request
                );

        CategoryAttribute savedAttribute =
                categoryAttributeRepository.save(attribute);

        saveOptions(
                savedAttribute,
                request.getOptions()
        );

        return categoryAttributeMapper
                .toResponse(savedAttribute);

    }

    @Override
    public CategoryAttributeResponse update(
            Long categoryId,
            Long attributeId,
            UpdateCategoryAttributeRequest request
    ) {

        Category category =
                getCategoryOrThrow(categoryId);

        CategoryAttribute attribute =
                getAttributeOrThrow(attributeId);

        validateAttributeBelongsToCategory(
                category,
                attribute
        );

        validateCategoryIsLeaf(
                attribute.getCategory()
        );

        String attributeName =
                normalizeAttributeName(request.getName());

        validateAttributeNameUniqueForUpdate(
                attribute,
                attributeName
        );

        validateSelectAttribute(

                request.getDataType(),

                request.getOptions()

        );

        updateAttribute(
                attribute,
                attributeName,
                request
        );

        replaceOptions(

                attribute,

                request.getOptions()

        );

        CategoryAttribute updatedAttribute =
                categoryAttributeRepository.save(attribute);

        return categoryAttributeMapper
                .toResponse(updatedAttribute);

    }

    @Override
    public void delete(
            Long categoryId,
            Long attributeId
    ) {

        Category category =
                getCategoryOrThrow(categoryId);

        CategoryAttribute attribute =
                getAttributeOrThrow(attributeId);

        validateAttributeBelongsToCategory(
                category,
                attribute
        );

        validateAttributeCanBeDeleted(attribute);

        categoryAttributeRepository.delete(attribute);

    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryAttributeResponse>
    getCategoryAttributes(
            Long categoryId
    ) {

        Category category =
                getCategoryOrThrow(categoryId);

        validateCategoryIsLeaf(category);

        return categoryAttributeRepository
                .findByCategoryOrderByNameAsc(category)
                .stream()
                .map(categoryAttributeMapper::toResponse)
                .toList();

    }

    private Category getCategoryOrThrow(
            Long categoryId
    ) {

        return categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.CATEGORY_NOT_FOUND
                        ));

    }

    private CategoryAttribute getAttributeOrThrow(
            Long attributeId
    ) {

        return categoryAttributeRepository.findById(attributeId)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.CATEGORY_ATTRIBUTE_NOT_FOUND
                        ));

    }

    private void validateAttributeNameUnique(
            Category category,
            String attributeName
    ) {

        if (categoryAttributeRepository
                .existsByCategoryAndNameIgnoreCase(
                        category,
                        attributeName
                )) {

            throw new BusinessException(
                    ErrorCode.CATEGORY_ATTRIBUTE_ALREADY_EXISTS
            );

        }

    }

    private void validateAttributeNameUniqueForUpdate(
            CategoryAttribute attribute,
            String attributeName
    ) {

        if (attribute.getName().equalsIgnoreCase(attributeName)) {
            return;
        }

        validateAttributeNameUnique(
                attribute.getCategory(),
                attributeName
        );

    }

    private void validateAttributeCanBeDeleted(
            CategoryAttribute attribute
    ) {

        validateAttributeNotUsed(attribute);

    }

    private CategoryAttribute buildAttribute(
            Category category,
            String attributeName,
            CreateCategoryAttributeRequest request
    ) {

        CategoryAttribute attribute =
                new CategoryAttribute();

        attribute.setCategory(category);

        attribute.setName(attributeName);

        attribute.setDataType(
                request.getDataType()
        );

        attribute.setRequired(
                request.isRequired()
        );

        return attribute;

    }

    private void updateAttribute(
            CategoryAttribute attribute,
            String attributeName,
            UpdateCategoryAttributeRequest request
    ) {

        attribute.setName(attributeName);

        attribute.setDataType(
                request.getDataType()
        );

        attribute.setRequired(
                request.isRequired()
        );

    }

    private String normalizeAttributeName(
            String name
    ) {

        String normalized = name.trim();

        if (normalized.isBlank()) {

            throw new BusinessException(
                    ErrorCode.INVALID_CATEGORY_ATTRIBUTE_NAME
            );

        }

        return normalized;

    }

    private void validateAttributeNotUsed(
            CategoryAttribute attribute
    ) {

        if (advertisementAttributeRepository
                .existsByCategoryAttribute(attribute)) {

            throw new BusinessException(
                    ErrorCode.CATEGORY_ATTRIBUTE_IN_USE
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

    private void validateAttributeBelongsToCategory(
            Category category,
            CategoryAttribute attribute
    ) {

        if (!attribute.getCategory()
                .getId()
                .equals(category.getId())) {

            throw new BusinessException(
                    ErrorCode.CATEGORY_ATTRIBUTE_NOT_FOUND
            );

        }

    }

    private void saveOptions(

            CategoryAttribute attribute,

            List<String> options

    ) {

        if (attribute.getDataType() != AttributeDataType.SELECT) {
            return;
        }

        if (options == null || options.isEmpty()) {

            throw new BusinessException(
                    ErrorCode.SELECT_ATTRIBUTE_OPTIONS_REQUIRED
            );

        }

        int order = 1;

        for (String value : options) {

            CategoryAttributeOption option =
                    new CategoryAttributeOption();

            option.setCategoryAttribute(attribute);

            option.setValue(value.trim());

            option.setDisplayOrder(order++);

            categoryAttributeOptionRepository.save(option);

        }

    }

    private void replaceOptions(

            CategoryAttribute attribute,

            List<String> options

    ) {

        categoryAttributeOptionRepository.deleteAll(

                categoryAttributeOptionRepository
                        .findByCategoryAttributeOrderByDisplayOrderAsc(
                                attribute
                        )

        );

        saveOptions(

                attribute,

                options

        );

    }

    private void validateSelectAttribute(

            AttributeDataType dataType,

            List<String> options

    ) {

        if (dataType == AttributeDataType.SELECT) {

            if (options == null || options.isEmpty()) {

                throw new BusinessException(

                        ErrorCode.SELECT_ATTRIBUTE_OPTIONS_REQUIRED

                );

            }

        }

    }



}