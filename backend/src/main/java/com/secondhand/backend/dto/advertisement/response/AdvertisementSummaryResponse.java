package com.secondhand.backend.dto.advertisement.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.secondhand.backend.dto.auth.response.UserSummaryResponse;
import com.secondhand.backend.dto.category.response.CategorySummaryResponse;
import com.secondhand.backend.dto.city.response.CitySummaryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AdvertisementSummaryResponse {

    private Long id;

    private String title;

    private BigDecimal price;

    private String primaryImageUrl;

    private CategorySummaryResponse category;

    private UserSummaryResponse seller;

    private CitySummaryResponse city;

    @JsonProperty("isFavorite")
    private boolean isFavorite;

    @JsonProperty("isOwner")
    private boolean isOwner;
}
