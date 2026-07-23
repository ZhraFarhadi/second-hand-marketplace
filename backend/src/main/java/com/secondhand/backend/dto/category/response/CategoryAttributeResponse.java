
package com.secondhand.backend.dto.category.response;

import com.secondhand.backend.enums.AttributeDataType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryAttributeResponse {

    private Long id;

    private String name;

    private AttributeDataType dataType;

    private boolean required;

    private List<String> options;

}