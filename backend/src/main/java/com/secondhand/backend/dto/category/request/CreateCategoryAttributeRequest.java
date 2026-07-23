package com.secondhand.backend.dto.category.request;

import com.secondhand.backend.enums.AttributeDataType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateCategoryAttributeRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    private AttributeDataType dataType;

    private boolean required;

    private List<String> options;

}
