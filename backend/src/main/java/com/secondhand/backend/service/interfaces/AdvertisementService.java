package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.advertisement.request.CreateAdvertisementRequest;
import com.secondhand.backend.dto.advertisement.request.MarkAsSoldRequest;
import com.secondhand.backend.dto.advertisement.request.UpdateAdvertisementRequest;
import com.secondhand.backend.dto.advertisement.response.AdvertisementDetailsResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.dto.advertisement.response.MyAdvertisementSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdvertisementService {

    AdvertisementDetailsResponse create(CreateAdvertisementRequest request);

    AdvertisementDetailsResponse update(
            Long advertisementId,
            UpdateAdvertisementRequest request
    );

    void delete(Long advertisementId);

    AdvertisementDetailsResponse markAsSold(
            Long advertisementId,
            MarkAsSoldRequest request
    );

    AdvertisementDetailsResponse getAdvertisementDetails(Long advertisementId);

    Page<AdvertisementSummaryResponse> getAdvertisements(Pageable pageable);

    Page<MyAdvertisementSummaryResponse> getMyAdvertisements(Pageable pageable);

}
