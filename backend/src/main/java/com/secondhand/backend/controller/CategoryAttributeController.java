package com.secondhand.backend.controller;
import com.secondhand.backend.dto.category.request.CreateCategoryAttributeRequest;
import com.secondhand.backend.dto.category.request.UpdateCategoryAttributeRequest;
import com.secondhand.backend.dto.category.response.CategoryAttributeResponse;
import com.secondhand.backend.service.interfaces.CategoryAttributeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryAttributeController {

    private final CategoryAttributeService categoryAttributeService;

    @PostMapping("/{categoryId}/attributes")
    @ResponseStatus(HttpStatus.CREATED)
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

    @GetMapping("/{categoryId}/attributes")
    public List<CategoryAttributeResponse> getAttributes(
            @PathVariable
            Long categoryId
    ) {

        return categoryAttributeService.getCategoryAttributes(
                categoryId
        );

    }

    @PutMapping("/{categoryId}/attributes/{attributeId}")
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

    @DeleteMapping("/{categoryId}/attributes/{attributeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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

}