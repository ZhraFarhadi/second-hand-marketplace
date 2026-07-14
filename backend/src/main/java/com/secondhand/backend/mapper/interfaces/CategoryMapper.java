package com.secondhand.backend.mapper.interfaces;


import com.secondhand.backend.dto.category.response.CategorySummaryResponse;
import com.secondhand.backend.entity.Category;

public interface CategoryMapper {

    CategorySummaryResponse toSummaryResponse(Category category);

}
