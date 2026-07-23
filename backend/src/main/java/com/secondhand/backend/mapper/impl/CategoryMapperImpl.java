package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.category.response.*;
import com.secondhand.backend.entity.Category;
import com.secondhand.backend.entity.CategoryAttribute;
import com.secondhand.backend.mapper.interfaces.CategoryAttributeMapper;
import com.secondhand.backend.mapper.interfaces.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapperImpl implements CategoryMapper {

    private final CategoryAttributeMapper categoryAttributeMapper;

    @Override
    public CategorySummaryResponse toSummaryResponse(
            Category category
    ) {

        if (category == null) {
            return null;
        }

        return new CategorySummaryResponse(
                category.getId(),
                category.getName()
        );

    }

    @Override
    public CategoryChildrenResponse toChildrenResponse(
            Category category,
            boolean hasChildren
    ) {

        if (category == null) {
            return null;
        }

        return new CategoryChildrenResponse(
                category.getId(),
                category.getName(),
                category.getParent() != null
                        ? category.getParent().getId()
                        : null,
                hasChildren
        );

    }

    @Override
    public CategoryDetailsResponse toDetailsResponse(
            Category category
    ) {

        if (category == null) {
            return null;
        }

        return new CategoryDetailsResponse(
                category.getId(),
                category.getName(),
                category.getParent() != null
                        ? category.getParent().getId()
                        : null,
                category.getChildren()
                        .stream()
                        .map(this::toSummaryResponse)
                        .toList(),
                category.getAttributes()
                        .stream()
                        .map(categoryAttributeMapper::toResponse)
                        .toList()
        );

    }

    @Override
    public CategoryWithAttributesResponse toCategoryWithAttributesResponse(
            Category category
    ) {

        if (category == null) {
            return null;
        }


        System.out.println("============== MAPPER ==============");

        System.out.println(category.getName());

        System.out.println(category.getAttributes().size());

        for (CategoryAttribute attribute : category.getAttributes()) {

            System.out.println(attribute.getName());

        }
        return new CategoryWithAttributesResponse(
                category.getId(),
                category.getName(),
                category.getParent() != null
                        ? category.getParent().getId()
                        : null,
                category.getAttributes()
                        .stream()
                        .map(categoryAttributeMapper::toResponse)
                        .toList()
        );

    }

    @Override
    public CategoryBreadcrumbItemResponse toBreadcrumbItem(
            Category category
    ) {

        if (category == null) {
            return null;
        }

        return new CategoryBreadcrumbItemResponse(
                category.getId(),
                category.getName()
        );

    }

}