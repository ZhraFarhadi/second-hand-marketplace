package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.service.CategoryService;

import java.util.List;

public class CategoryRepository {

    private static final CategoryRepository INSTANCE =
            new CategoryRepository();

    private final CategoryService categoryService =
            CategoryService.getInstance();

    private CategoryRepository() {
    }

    public static CategoryRepository getInstance() {
        return INSTANCE;
    }

    /**
     * فقط دسته‌بندی‌های ریشه را برمی‌گرداند.
     */
    public List<CategorySummaryResponse> getRootCategories()
            throws Exception {

        return categoryService.getRootCategories();

    }

    /**
     * جزئیات یک دسته‌بندی شامل Attributeها را برمی‌گرداند.
     */
    public CategoryDetailsResponse getCategory(Long id)
            throws Exception {

        return categoryService.getCategory(id);

    }

    public List<CategorySummaryResponse> getChildren(Long categoryId)
            throws Exception {

        return categoryService.getChildren(categoryId);

    }

}