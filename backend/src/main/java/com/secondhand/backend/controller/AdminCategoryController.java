
package com.secondhand.backend.controller;

import com.secondhand.backend.dto.category.request.CreateCategoryRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryRequest;
import com.secondhand.backend.dto.category.response.*;
import com.secondhand.backend.service.interfaces.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategorySummaryResponse create(
            @Valid
            @RequestBody
            CreateCategoryRequest request
    ) {

        return categoryService.create(request);

    }

    @PutMapping("/{categoryId}")
    public CategorySummaryResponse update(
            @PathVariable
            Long categoryId,

            @Valid
            @RequestBody
            UpdateCategoryRequest request
    ) {

        return categoryService.update(
                categoryId,
                request
        );

    }

    @DeleteMapping("/{categoryId}")
    public void delete(
            @PathVariable
            Long categoryId
    ) {

        categoryService.delete(categoryId);

    }

    @GetMapping
    public List<CategoryDetailsResponse> getCategories() {

        return categoryService.getCategories();

    }



    @GetMapping("/{categoryId}")
    public CategoryWithAttributesResponse getCategoryDetails(
            @PathVariable
            Long categoryId
    ) {

        return categoryService.getCategoryDetails(categoryId);

    }

    @GetMapping("/{categoryId}/children")
    public List<CategoryChildrenResponse> getChildren(
            @PathVariable
            Long categoryId
    ) {

        return categoryService.getChildren(categoryId);

    }

    @GetMapping("/{categoryId}/breadcrumb")
    public List<CategoryBreadcrumbItemResponse> getBreadcrumb(
            @PathVariable
            Long categoryId
    ) {

        return categoryService.getBreadcrumb(categoryId);

    }

}