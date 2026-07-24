package com.secondhand.frontend.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.common.PageResponse;
import com.secondhand.frontend.dto.rating.request.CreateSellerRatingRequest;
import com.secondhand.frontend.dto.rating.response.SellerProfileResponse;
import com.secondhand.frontend.dto.rating.response.SellerRatingResponse;
import com.secondhand.frontend.util.JsonUtil;

import java.lang.reflect.Type;

public class RatingService {

    private static final RatingService INSTANCE =
            new RatingService();

    private static final Gson gson =
            JsonUtil.getGson();

    private RatingService() {
    }

    public static RatingService getInstance() {
        return INSTANCE;
    }

    /*
     * ===========================
     * Create Rating
     * ===========================
     */

    public SellerRatingResponse createRating(
            Long advertisementId,
            CreateSellerRatingRequest request
    ) throws Exception {

        String response =
                ApiClient.post(
                        "/ratings/advertisements/" + advertisementId,
                        request
                );

        return gson.fromJson(
                response,
                SellerRatingResponse.class
        );

    }

    /*
     * ===========================
     * Get Seller Ratings (paged)
     * ===========================
     */

    public PageResponse<SellerRatingResponse> getSellerRatings(
            Long sellerId,
            int page,
            int size
    ) throws Exception {

        String response =
                ApiClient.get(
                        "/ratings/seller/" + sellerId
                                + "?page=" + page
                                + "&size=" + size
                );

        Type type =
                new TypeToken<PageResponse<SellerRatingResponse>>() {
                }.getType();

        return gson.fromJson(response, type);

    }

    /*
     * ===========================
     * Get Seller Profile (avg rating + count)
     * ===========================
     */

    public SellerProfileResponse getSellerProfile(
            Long sellerId
    ) throws Exception {

        String response =
                ApiClient.get(
                        "/users/" + sellerId + "/profile"
                );

        return gson.fromJson(
                response,
                SellerProfileResponse.class
        );

    }

}