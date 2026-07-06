package com.secondhand.backend.dto.category.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryDetailsResponse {

    private Long id;

    private String name;

    private Long parentId;

}
