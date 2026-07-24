package com.secondhand.frontend.service;

import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.dto.common.PageResponse;

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
                new TypeToken<PageResponse<AdvertisementSummaryResponse>>() {}.getType();

        PageResponse<AdvertisementSummaryResponse> page =
                ApiClient.get(
                        "/favorites",
                        type
                );

        return page.getContent();

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