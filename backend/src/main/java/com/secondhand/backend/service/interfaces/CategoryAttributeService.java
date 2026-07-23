package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.category.request.CreateCategoryAttributeRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryAttributeRequest;
import com.secondhand.backend.dto.category.response.CategoryAttributeResponse;

import java.util.List;

public interface CategoryAttributeService {


    CategoryAttributeResponse create(
            Long categoryId,
            CreateCategoryAttributeRequest request
    );

    CategoryAttributeResponse update(
            Long categoryId,
            Long attributeId,
            UpdateCategoryAttributeRequest request
    );

    void delete(
            Long categoryId,
            Long attributeId
    );

    List<CategoryAttributeResponse> getCategoryAttributes(
            Long categoryId
    );



}