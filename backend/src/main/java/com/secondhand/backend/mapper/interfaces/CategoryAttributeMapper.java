package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.category.response.CategoryAttributeResponse;
import com.secondhand.backend.entity.CategoryAttribute;

public interface CategoryAttributeMapper {

    CategoryAttributeResponse toResponse(
            CategoryAttribute attribute
    );

}
