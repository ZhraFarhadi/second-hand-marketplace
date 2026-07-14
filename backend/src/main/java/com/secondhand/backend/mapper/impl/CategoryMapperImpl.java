package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.category.response.CategorySummaryResponse;
import com.secondhand.backend.entity.Category;
import com.secondhand.backend.mapper.interfaces.CategoryMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategorySummaryResponse toSummaryResponse(Category category) {

        if (category == null) {
            return null;
        }

        return new CategorySummaryResponse(
                category.getId(),
                category.getName()
        );
    }
}