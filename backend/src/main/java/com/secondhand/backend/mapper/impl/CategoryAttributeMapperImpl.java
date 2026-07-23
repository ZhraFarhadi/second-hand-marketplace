package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.category.response.CategoryAttributeResponse;
import com.secondhand.backend.entity.CategoryAttribute;
import com.secondhand.backend.entity.CategoryAttributeOption;
import com.secondhand.backend.mapper.interfaces.CategoryAttributeMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryAttributeMapperImpl
        implements CategoryAttributeMapper {

    @Override
    public CategoryAttributeResponse toResponse(
            CategoryAttribute attribute
    ) {

        if (attribute == null) {
            return null;
        }

        return new CategoryAttributeResponse(

                attribute.getId(),

                attribute.getName(),

                attribute.getDataType(),

                attribute.isRequired(),

                attribute.getOptions()
                        .stream()
                        .map(CategoryAttributeOption::getValue)
                        .toList()

        );

    }
}
