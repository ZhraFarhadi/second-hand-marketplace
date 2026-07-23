package com.secondhand.frontend.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.province.response.ProvinceResponse;
import com.secondhand.frontend.util.JsonUtil;

import java.lang.reflect.Type;
import java.util.List;

public class ProvinceService {

    private static final ProvinceService INSTANCE =
            new ProvinceService();

    private static final Gson gson =
            JsonUtil.getGson();

    private ProvinceService() {
    }

    public static ProvinceService getInstance() {
        return INSTANCE;
    }

    public List<ProvinceResponse> getProvinces()
            throws Exception {

        String response =
                ApiClient.get("/provinces");

        Type type =
                new TypeToken<List<ProvinceResponse>>(){}.getType();

        return gson.fromJson(response, type);

    }

}