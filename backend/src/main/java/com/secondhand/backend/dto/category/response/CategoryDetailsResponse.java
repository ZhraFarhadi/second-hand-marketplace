package com.secondhand.backend.dto.category.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryDetailsResponse {

    private Long id;

    private String name;

    private Long parentId;

    private List<CategorySummaryResponse> children;

    private List<CategoryAttributeResponse> attributes;

}