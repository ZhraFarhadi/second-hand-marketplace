package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.service.CategoryService;

import java.util.List;

public class CategoryRepository {

    private static final CategoryRepository INSTANCE =
            new CategoryRepository();

    private final CategoryService service =
            CategoryService.getInstance();

    private CategoryRepository() {
    }

    public static CategoryRepository getInstance() {
        return INSTANCE;
    }

    public List<CategoryDetailsResponse> getCategories()
            throws Exception {

        return service.getRootCategories();

    }

    public CategoryDetailsResponse getCategory(Long id)
            throws Exception {

        return service.getCategory(id);

    }

}