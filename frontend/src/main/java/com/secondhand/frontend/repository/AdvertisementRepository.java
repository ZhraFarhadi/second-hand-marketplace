package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.advertisement.request.CreateAdvertisementRequest;
import com.secondhand.frontend.dto.advertisement.request.UpdateAdvertisementRequest;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementDetailsResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.dto.advertisement.response.MyAdvertisementSummaryResponse;
import com.secondhand.frontend.dto.common.PageResponse;
import com.secondhand.frontend.service.AdvertisementService;

import java.util.List;

public class AdvertisementRepository {

    private static final AdvertisementRepository INSTANCE =
            new AdvertisementRepository();

    private final AdvertisementService advertisementService =
            AdvertisementService.getInstance();

    private AdvertisementRepository() {
    }

    public static AdvertisementRepository getInstance() {
        return INSTANCE;
    }

    /*
     * ===========================
     * Advertisements
     * ===========================
     */

    public List<AdvertisementSummaryResponse> getAdvertisements(
            int page,
            int size
    ) throws Exception {

        PageResponse<AdvertisementSummaryResponse> response =
                advertisementService.getAdvertisements(page, size);

        return response.getContent();

    }

    /*
     * ===========================
     * My Advertisements
     * ===========================
     */

    public List<MyAdvertisementSummaryResponse> getMyAdvertisements(
            int page,
            int size
    ) throws Exception {

        PageResponse<MyAdvertisementSummaryResponse> response =
                advertisementService.getMyAdvertisements(page, size);

        return response.getContent();

    }

    /*
     * ===========================
     * Advertisement Details
     * ===========================
     */

    public AdvertisementDetailsResponse getAdvertisement(Long id)
            throws Exception {

        return advertisementService.getAdvertisement(id);

    }

    /*
     * ===========================
     * Create
     * ===========================
     */

    public AdvertisementDetailsResponse createAdvertisement(
            CreateAdvertisementRequest request
    ) throws Exception {

        return advertisementService.createAdvertisement(request);

    }

    /*
     * ===========================
     * Update
     * ===========================
     */

    public AdvertisementDetailsResponse updateAdvertisement(
            Long id,
            UpdateAdvertisementRequest request
    ) throws Exception {

        return advertisementService.updateAdvertisement(id, request);

    }

    /*
     * ===========================
     * Mark As Sold
     * ===========================
     */

    public AdvertisementDetailsResponse markAsSold(Long id)
            throws Exception {

        return advertisementService.markAsSold(id);

    }

    /*
     * ===========================
     * Delete
     * ===========================
     */

    public void deleteAdvertisement(Long id)
            throws Exception {

        advertisementService.deleteAdvertisement(id);

    }

    public AdvertisementDetailsResponse getAdvertisementDetails(
            Long id
    ) throws Exception {

        return advertisementService.getAdvertisementDetails(id);

    }

}