package com.secondhand.backend.controller;

import com.secondhand.backend.dto.category.request.CreateCategoryAttributeRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryAttributeRequest;
import com.secondhand.backend.dto.category.response.CategoryAttributeResponse;
import com.secondhand.backend.service.interfaces.CategoryAttributeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categories/{categoryId}/attributes")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminCategoryAttributeController {

    private final CategoryAttributeService categoryAttributeService;

    @PostMapping
    public CategoryAttributeResponse create(
            @PathVariable
            Long categoryId,

            @Valid
            @RequestBody
            CreateCategoryAttributeRequest request
    ) {

        return categoryAttributeService.create(
                categoryId,
                request
        );

    }

    @PutMapping("/{attributeId}")
    public CategoryAttributeResponse update(
            @PathVariable
            Long categoryId,

            @PathVariable
            Long attributeId,

            @Valid
            @RequestBody
            UpdateCategoryAttributeRequest request
    ) {

        return categoryAttributeService.update(
                categoryId,
                attributeId,
                request
        );

    }

    @DeleteMapping("/{attributeId}")
    public void delete(
            @PathVariable
            Long categoryId,

            @PathVariable
            Long attributeId
    ) {

        categoryAttributeService.delete(
                categoryId,
                attributeId
        );

    }

    @GetMapping
    public List<CategoryAttributeResponse> getCategoryAttributes(
            @PathVariable
            Long categoryId
    ) {

        return categoryAttributeService.getCategoryAttributes(
                categoryId
        );

    }

}