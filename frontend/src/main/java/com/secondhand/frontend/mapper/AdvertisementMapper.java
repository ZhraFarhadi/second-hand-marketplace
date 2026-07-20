package com.secondhand.frontend.mapper;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.model.AdvertisementCardModel;

public final class AdvertisementMapper {

    private AdvertisementMapper() {
    }

    public static AdvertisementCardModel toCardModel(
            AdvertisementSummaryResponse dto
    ) {

        AdvertisementCardModel model =
                new AdvertisementCardModel();

        model.setId(dto.getId());

        model.setTitle(dto.getTitle());

        model.setPrice(dto.getPrice());

        model.setImageUrl(dto.getPrimaryImageUrl());

        model.setSellerName(
                dto.getSeller().getFullName()
        );

        model.setCityName(
                dto.getCity().getName()
        );

        model.setCategoryName(
                dto.getCategory().getName()
        );

        return model;
    }

}