package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.category.request.CreateCategoryRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryRequest;
import com.secondhand.backend.dto.category.response.*;

import java.util.List;

public interface CategoryService {

    CategorySummaryResponse create(
            CreateCategoryRequest request
    );

    CategorySummaryResponse update(
            Long categoryId,
            UpdateCategoryRequest request
    );

    void delete(
            Long categoryId
    );

    List<CategoryDetailsResponse> getCategories();

    CategoryWithAttributesResponse getCategoryDetails(
            Long categoryId
    );

    List<CategoryChildrenResponse> getChildren(Long categoryId);

    List<CategoryBreadcrumbItemResponse> getBreadcrumb(
            Long categoryId
    );

}
