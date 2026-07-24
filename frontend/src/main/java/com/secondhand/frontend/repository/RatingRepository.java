package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.rating.request.CreateSellerRatingRequest;
import com.secondhand.frontend.dto.rating.response.SellerProfileResponse;
import com.secondhand.frontend.dto.rating.response.SellerRatingResponse;
import com.secondhand.frontend.service.RatingService;

import java.util.List;

public class RatingRepository {

    private static final RatingRepository INSTANCE =
            new RatingRepository();

    private final RatingService ratingService =
            RatingService.getInstance();

    private RatingRepository() {
    }

    public static RatingRepository getInstance() {
        return INSTANCE;
    }

    /*
     * ===========================
     * Create Rating
     * ===========================
     */

    public SellerRatingResponse createRating(
            Long advertisementId,
            Integer score,
            String comment
    ) throws Exception {

        CreateSellerRatingRequest request =
                new CreateSellerRatingRequest(score, comment);

        return ratingService.createRating(
                advertisementId,
                request
        );

    }

    /*
     * ===========================
     * Get Seller Ratings
     * ===========================
     */

    public List<SellerRatingResponse> getSellerRatings(
            Long sellerId,
            int page,
            int size
    ) throws Exception {

        return ratingService
                .getSellerRatings(sellerId, page, size)
                .getContent();

    }

    /*
     * ===========================
     * Get Seller Profile
     * ===========================
     */

    public SellerProfileResponse getSellerProfile(
            Long sellerId
    ) throws Exception {

        return ratingService.getSellerProfile(sellerId);

    }

}