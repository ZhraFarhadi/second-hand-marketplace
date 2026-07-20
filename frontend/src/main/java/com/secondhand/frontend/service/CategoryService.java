package com.secondhand.frontend.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.util.JsonUtil;

import java.lang.reflect.Type;
import java.util.List;

public class CategoryService {

    private static final CategoryService INSTANCE =
            new CategoryService();

    private static final Gson gson =
            JsonUtil.getGson();

    private CategoryService() {
    }

    public static CategoryService getInstance() {
        return INSTANCE;
    }

    public List<CategoryDetailsResponse>  getRootCategories()
            throws Exception {

        String response =
                ApiClient.get("/categories");

        Type type =
                new TypeToken<List<CategorySummaryResponse>>(){}.getType();

        return gson.fromJson(response, type);

    }

    public CategoryDetailsResponse getCategory(Long id)
            throws Exception {

        String response =
                ApiClient.get("/categories/" + id);

        return gson.fromJson(
                response,
                CategoryDetailsResponse.class
        );

    }

}