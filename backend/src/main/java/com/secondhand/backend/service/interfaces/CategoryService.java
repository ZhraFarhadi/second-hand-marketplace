package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.category.request.CreateCategoryRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryRequest;
import com.secondhand.backend.dto.category.response.CategoryBreadcrumbItemResponse;
import com.secondhand.backend.dto.category.response.CategoryChildrenResponse;
import com.secondhand.backend.dto.category.response.CategorySummaryResponse;
import com.secondhand.backend.dto.category.response.CategoryWithAttributesResponse;

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

    List<CategorySummaryResponse> getCategories();

    CategoryWithAttributesResponse getCategoryDetails(
            Long categoryId
    );

    List<CategoryChildrenResponse> getChildren(Long categoryId);

    List<CategoryBreadcrumbItemResponse> getBreadcrumb(
            Long categoryId
    );

}
