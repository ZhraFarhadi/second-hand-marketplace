package com.secondhand.backend.dto.rating.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

    @Getter
    @AllArgsConstructor
    public class SellerProfileResponse {

        private Long id;

        private String fullName;

        private String username;

        private Double averageRating;

        private Long ratingCount;

    }

