package com.secondhand.backend.dto.advertisement.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.secondhand.backend.dto.auth.response.UserSummaryResponse;
import com.secondhand.backend.dto.category.response.CategorySummaryResponse;
import com.secondhand.backend.dto.city.response.CitySummaryResponse;
import com.secondhand.backend.enums.AdvertisementStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AdvertisementDetailsResponse {

    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private AdvertisementStatus status;

    private UserSummaryResponse seller;

    private UserSummaryResponse buyer;

    private CategorySummaryResponse category;

    private CitySummaryResponse city;

    private List<AdvertisementImageResponse> images;

    private List<AdvertisementAttributeResponse> attributes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonProperty("isFavorite")
    private boolean isFavorite;

    @JsonProperty("isOwner")
    private boolean isOwner;
}