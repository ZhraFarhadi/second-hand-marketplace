
package com.secondhand.backend.dto.category.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryWithAttributesResponse {

    private Long id;

    private String name;

    private Long parentId;

    private List<CategoryAttributeResponse> attributes;

}