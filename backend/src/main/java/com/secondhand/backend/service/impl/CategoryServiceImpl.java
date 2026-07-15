package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.category.request.CreateCategoryRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryRequest;
import com.secondhand.backend.dto.category.response.CategoryBreadcrumbItemResponse;
import com.secondhand.backend.dto.category.response.CategoryChildrenResponse;
import com.secondhand.backend.dto.category.response.CategorySummaryResponse;
import com.secondhand.backend.dto.category.response.CategoryWithAttributesResponse;
import com.secondhand.backend.entity.Category;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.CategoryMapper;
import com.secondhand.backend.repository.AdvertisementRepository;
import com.secondhand.backend.repository.CategoryRepository;
import com.secondhand.backend.service.interfaces.CategoryService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final AdvertisementRepository advertisementRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public CategorySummaryResponse create(
            CreateCategoryRequest request
    ) {

        String categoryName =
                normalizeCategoryName(
                        request.getName()
                );

        validateCategoryNameUnique(categoryName);

        Category parent =
                getParentCategoryOrNull(request.getParentId());

        Category category =
                buildCategory(
                        categoryName,
                        parent
                );

        Category savedCategory =
                categoryRepository.save(category);

        return categoryMapper.toSummaryResponse(savedCategory);

    }

    @Override
    public CategorySummaryResponse update(
            Long categoryId,
            UpdateCategoryRequest request
    ) {

        Category category =
                getCategoryOrThrow(categoryId);

        String categoryName =
                normalizeCategoryName(
                        request.getName()
                );

        validateCategoryNameUniqueForUpdate(
                category,
                categoryName
        );

        Category parent =
                getParentCategoryOrNull(request.getParentId());

        validateHierarchy(
                category,
                parent
        );

        updateCategory(
                category,
                categoryName,
                parent
        );

        Category updatedCategory =
                categoryRepository.save(category);

        return categoryMapper.toSummaryResponse(updatedCategory);

    }

    @Override
    public void delete(
            Long categoryId
    ) {

        Category category =
                getCategoryOrThrow(categoryId);

        validateCategoryCanBeDeleted(category);

        categoryRepository.delete(category);

    }

    @Override
    @Transactional(readOnly = true)
    public List<CategorySummaryResponse> getCategories() {
        return categoryRepository.findAllByParentIsNullOrderByNameAsc()
                .stream()
                .map(categoryMapper::toSummaryResponse)
                .toList();

    }

    @Override
    @Transactional(readOnly = true)
    public CategoryWithAttributesResponse getCategoryDetails(
            Long categoryId
    ) {

        Category category =
                getCategoryOrThrow(categoryId);

        return categoryMapper
                .toCategoryWithAttributesResponse(category);

    }


    @Override
    @Transactional(readOnly = true)
    public List<CategoryBreadcrumbItemResponse> getBreadcrumb(
            Long categoryId
    ) {

        Category category = getCategoryOrThrow(categoryId);

        List<CategoryBreadcrumbItemResponse> breadcrumb =
                new ArrayList<>();

        Category current = category;

        while (current != null) {

            breadcrumb.add(
                    categoryMapper.toBreadcrumbItem(current)
            );

            current = current.getParent();
        }

        Collections.reverse(breadcrumb);

        return breadcrumb;

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

    private Category getParentCategoryOrNull(
            Long parentId
    ) {

        if (parentId == null) {
            return null;
        }

        return getCategoryOrThrow(parentId);

    }

    private void validateCategoryNameUnique(
            String categoryName
    ) {

        if (categoryRepository.existsByNameIgnoreCase(categoryName)) {

            throw new BusinessException(
                    ErrorCode.CATEGORY_NAME_ALREADY_EXISTS
            );

        }

    }


    private void validateHierarchy(
            Category category,
            Category parent
    ) {

        validateParentIsNotSelf(
                category,
                parent
        );

        validateNoCircularHierarchy(
                category,
                parent
        );

    }

    private void validateParentIsNotSelf(
            Category category,
            Category parent
    ) {

        if (parent == null) {
            return;
        }

        if (category.getId().equals(parent.getId())) {

            throw new BusinessException(
                    ErrorCode.INVALID_CATEGORY_HIERARCHY,
                    "Category cannot be its own parent."
            );

        }

    }

    private void validateNoCircularHierarchy(
            Category category,
            Category parent
    ) {

        if (parent == null) {
            return;
        }

        if (isDescendant(parent, category)) {

            throw new BusinessException(
                    ErrorCode.INVALID_CATEGORY_HIERARCHY,
                    "Circular category hierarchy detected."
            );

        }

    }

    private void validateCategoryCanBeDeleted(
            Category category
    ) {

        validateHasNoChildren(category);

        validateHasNoAdvertisements(category);

    }


    private void validateHasNoChildren(
            Category category
    ) {

        if (categoryRepository.existsByParent(category)) {

            throw new BusinessException(
                    ErrorCode.CATEGORY_HAS_CHILDREN
            );

        }

    }

    private void validateHasNoAdvertisements(
            Category category
    ) {

        if (advertisementRepository
                .existsByCategoryAndDeletedAtIsNull(category)) {

            throw new BusinessException(
                    ErrorCode.CATEGORY_HAS_ADVERTISEMENTS
            );

        }

    }

    private void validateCategoryNameUniqueForUpdate(
            Category category,
            String categoryName
    ) {

        if (category.getName().equalsIgnoreCase(categoryName)) {
            return;
        }

        validateCategoryNameUnique(categoryName);

    }

    private Category buildCategory(
            String categoryName,
            Category parent
    ) {

        Category category = new Category();

        category.setName(categoryName);

        category.setParent(parent);

        return category;

    }

    private void updateCategory(
            Category category,
            String categoryName,
            Category parent
    ) {

        category.setName(categoryName);

        category.setParent(parent);

    }

    private boolean isDescendant(
            Category parent,
            Category category
    ) {

        Category current = parent;

        while (current != null) {

            if (current.getId().equals(category.getId())) {
                return true;
            }

            current = current.getParent();

        }

        return false;

    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryChildrenResponse> getChildren(
            Long categoryId
    ) {

        Category parent = getCategoryOrThrow(categoryId);

        List<Category> children =
                categoryRepository.findAllByParentOrderByNameAsc(parent);

        Set<Long> parentIds =
                new HashSet<>(categoryRepository.findParentCategoryIds());

        return children.stream()
                .map(category ->
                        categoryMapper.toChildrenResponse(
                                category,
                                parentIds.contains(category.getId())
                        )
                )
                .toList();

    }

    private String normalizeCategoryName(
            String name
    ) {

        String trimmed = name.trim().toLowerCase();

        String[] words = trimmed.split("\\s+");

        StringBuilder builder = new StringBuilder();

        for (String word : words) {

            if (word.isEmpty()) {
                continue;
            }

            builder.append(
                    Character.toUpperCase(word.charAt(0))
            );

            if (word.length() > 1) {
                builder.append(word.substring(1));
            }

            builder.append(" ");
        }

        return builder.toString().trim();

    }

}


