package com.secondhand.frontend.dto.favorite.response;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;

public class FavoriteResponse {

    private Long id;

    private AdvertisementSummaryResponse advertisement;

    public FavoriteResponse() {
    }

    public Long getId() {
        return id;
    }

    public AdvertisementSummaryResponse getAdvertisement() {
        return advertisement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdvertisement(AdvertisementSummaryResponse advertisement) {
        this.advertisement = advertisement;
    }

}