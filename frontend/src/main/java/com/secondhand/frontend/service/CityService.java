package com.secondhand.frontend.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.city.response.CitySummaryResponse;
import com.secondhand.frontend.util.JsonUtil;

import java.lang.reflect.Type;
import java.util.List;

public class CityService {

    private static final CityService INSTANCE =
            new CityService();

    private static final Gson gson =
            JsonUtil.getGson();

    private CityService() {
    }

    public static CityService getInstance() {
        return INSTANCE;
    }

    public List<CitySummaryResponse> getCitiesByProvince(Long provinceId)
            throws Exception {

        String response =
                ApiClient.get("/provinces/" + provinceId + "/cities");

        Type type =
                new TypeToken<List<CitySummaryResponse>>() {}.getType();

        return gson.fromJson(response, type);
    }
}