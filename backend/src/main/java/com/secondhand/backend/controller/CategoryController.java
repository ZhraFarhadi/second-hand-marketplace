package com.secondhand.backend.controller;

import com.secondhand.backend.dto.category.request.CreateCategoryRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryRequest;
import com.secondhand.backend.dto.category.response.CategoryBreadcrumbItemResponse;
import com.secondhand.backend.dto.category.response.CategoryChildrenResponse;
import com.secondhand.backend.dto.category.response.CategorySummaryResponse;
import com.secondhand.backend.dto.category.response.CategoryWithAttributesResponse;
import com.secondhand.backend.service.interfaces.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategorySummaryResponse> create(
            @Valid
            @RequestBody
            CreateCategoryRequest request
    ) {

        CategorySummaryResponse response =
                categoryService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable
            Long categoryId
    ) {

        categoryService.delete(categoryId);

    }

    @GetMapping("/root")
    public List<CategorySummaryResponse> getRootCategories() {

        return categoryService.getCategories();

    }

    @GetMapping("/{categoryId}")
    public CategoryWithAttributesResponse getCategoryDetails(
            @PathVariable
            Long categoryId
    ) {

        return categoryService.getCategoryDetails(
                categoryId
        );

    }

    @GetMapping("/{categoryId}/children")
    public List<CategoryChildrenResponse> getChildren(
            @PathVariable
            Long categoryId
    ) {

        return categoryService.getChildren(
                categoryId
        );

    }

    @GetMapping("/{categoryId}/breadcrumb")
    public List<CategoryBreadcrumbItemResponse> getBreadcrumb(
            @PathVariable
            Long categoryId
    ) {

        return categoryService.getBreadcrumb(
                categoryId
        );

    }

}
