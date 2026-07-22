package com.secondhand.frontend.service;

import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;

import java.lang.reflect.Type;
import java.util.List;

public class FavoriteService {

    public void toggleFavorite(Long advertisementId) throws Exception {

        ApiClient.post(
                "/favorites/" + advertisementId,
                null
        );

    }

    public List<AdvertisementSummaryResponse> getFavorites() throws Exception {

        Type type =
                new TypeToken<List<AdvertisementSummaryResponse>>() {}.getType();

        return ApiClient.get(
                "/favorites",
                type
        );

    }

    public int getFavoritesCount() throws Exception {

        Type type =
                new TypeToken<FavoriteCountResponse>() {}.getType();

        FavoriteCountResponse response =
                ApiClient.get(
                        "/favorites/count",
                        type
                );

        return response.count();

    }

    private record FavoriteCountResponse(int count) {}

}