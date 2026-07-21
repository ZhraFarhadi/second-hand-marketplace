package com.secondhand.frontend.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.advertisement.request.CreateAdvertisementRequest;
import com.secondhand.frontend.dto.advertisement.request.UpdateAdvertisementRequest;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementDetailsResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.dto.advertisement.response.MyAdvertisementSummaryResponse;
import com.secondhand.frontend.dto.common.PageResponse;
import com.secondhand.frontend.util.JsonUtil;

import java.lang.reflect.Type;

public class AdvertisementService {

    private static final AdvertisementService INSTANCE =
            new AdvertisementService();

    private static final Gson gson =
            JsonUtil.getGson();

    private AdvertisementService() {
    }

    public static AdvertisementService getInstance() {
        return INSTANCE;
    }

    /*
     * ===========================
     * Get Advertisements
     * ===========================
     */

    public PageResponse<AdvertisementSummaryResponse> getAdvertisements(
            int page,
            int size
    ) throws Exception {

        String response =
                ApiClient.get(
                        "/advertisements?page="
                                + page
                                + "&size="
                                + size
                );

        Type type =
                new TypeToken<PageResponse<AdvertisementSummaryResponse>>() {
                }.getType();

        return gson.fromJson(response, type);

    }

    /*
     * ===========================
     * Get My Advertisements
     * ===========================
     */

    public PageResponse<MyAdvertisementSummaryResponse> getMyAdvertisements(
            int page,
            int size
    ) throws Exception {

        String response =
                ApiClient.get(
                        "/advertisements/my?page="
                                + page
                                + "&size="
                                + size
                );

        Type type =
                new TypeToken<PageResponse<MyAdvertisementSummaryResponse>>() {
                }.getType();

        return gson.fromJson(response, type);

    }

    /*
     * ===========================
     * Get Advertisement Details
     * ===========================
     */

    public AdvertisementDetailsResponse getAdvertisement(
            Long id
    ) throws Exception {

        String response =
                ApiClient.get(
                        "/advertisements/" + id
                );

        return gson.fromJson(
                response,
                AdvertisementDetailsResponse.class
        );

    }

    /*
     * ===========================
     * Create Advertisement
     * ===========================
     */

    public AdvertisementDetailsResponse createAdvertisement(
            CreateAdvertisementRequest request
    ) throws Exception {

        String response =
                ApiClient.post(
                        "/advertisements",
                        request
                );

        return gson.fromJson(
                response,
                AdvertisementDetailsResponse.class
        );

    }

    /*
     * ===========================
     * Update Advertisement
     * ===========================
     */

    public AdvertisementDetailsResponse updateAdvertisement(
            Long id,
            UpdateAdvertisementRequest request
    ) throws Exception {

        String response =
                ApiClient.put(
                        "/advertisements/" + id,
                        request
                );

        return gson.fromJson(
                response,
                AdvertisementDetailsResponse.class
        );

    }

    /*
     * ===========================
     * Delete Advertisement
     * ===========================
     */

    public void deleteAdvertisement(
            Long id
    ) throws Exception {

        ApiClient.delete(
                "/advertisements/" + id
        );

    }

    /*
     * ===========================
     * Mark Advertisement As Sold
     * ===========================
     */

    public AdvertisementDetailsResponse markAsSold(
            Long id
    ) throws Exception {

        String response =
                ApiClient.patch(
                        "/advertisements/" + id + "/sold"
                );

        return gson.fromJson(
                response,
                AdvertisementDetailsResponse.class
        );

    }

    public AdvertisementDetailsResponse getAdvertisementDetails(
            Long id
    ) throws Exception {

        String response =
                ApiClient.get(
                        "/advertisements/" + id
                );

        return gson.fromJson(
                response,
                AdvertisementDetailsResponse.class
        );

    }

}