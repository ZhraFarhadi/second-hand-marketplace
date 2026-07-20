package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.rating.response.SellerRatingResponse;
import com.secondhand.backend.entity.SellerRating;

public interface SellerRatingMapper {

    SellerRatingResponse toResponse(
            SellerRating sellerRating
    );

}