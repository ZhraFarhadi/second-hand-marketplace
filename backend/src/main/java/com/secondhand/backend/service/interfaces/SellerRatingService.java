package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.rating.request.CreateSellerRatingRequest;
import com.secondhand.backend.dto.rating.response.SellerRatingResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellerRatingService {

    SellerRatingResponse create(
            Long advertisementId,
            CreateSellerRatingRequest request
    );

    Page<SellerRatingResponse> getSellerRatings(
            Long sellerId,
            Pageable pageable
    );

}