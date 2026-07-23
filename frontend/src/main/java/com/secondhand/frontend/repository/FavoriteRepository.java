package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.service.FavoriteService;

import java.util.List;

public class FavoriteRepository {

    private final FavoriteService service =
            new FavoriteService();

    public void toggleFavorite(Long advertisementId) throws Exception {

        service.toggleFavorite(advertisementId);

    }

    public List<AdvertisementSummaryResponse> getFavorites() throws Exception {

        return service.getFavorites();

    }

    public int getFavoritesCount() throws Exception {

        return service.getFavoritesCount();

    }

}