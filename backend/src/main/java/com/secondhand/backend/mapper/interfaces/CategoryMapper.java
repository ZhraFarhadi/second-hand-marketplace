package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.category.response.*;
import com.secondhand.backend.entity.Category;
import com.secondhand.backend.entity.CategoryAttribute;

public interface CategoryMapper {

    CategorySummaryResponse toSummaryResponse(Category category);

    CategoryDetailsResponse toDetailsResponse(Category category);

    CategoryWithAttributesResponse toCategoryWithAttributesResponse(Category category);

    CategoryAttributeResponse toCategoryAttributeResponse(CategoryAttribute attribute);

    CategoryChildrenResponse toChildrenResponse(
            Category category,
            boolean hasChildren
    );

    CategoryBreadcrumbItemResponse toBreadcrumbItem(
            Category category
    );

}
