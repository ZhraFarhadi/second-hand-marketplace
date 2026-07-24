package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.admin.request.CreateAdminReviewRequest;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminReviewResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementSummaryResponse;

public interface AdminReviewService {

    Page<AdminAdvertisementSummaryResponse> getPendingAdvertisements(
            Pageable pageable
    );

    AdminReviewResponse reviewAdvertisement(
            Long advertisementId,
            CreateAdminReviewRequest request
    );

    Page<AdminReviewResponse> getAdvertisementReviews(
            Long advertisementId,
            Pageable pageable
    );

    Page<AdminReviewResponse> getMyReviews(
            Pageable pageable
    );

    Page<AdminAdvertisementSummaryResponse> getAllAdvertisements(
            Pageable pageable
    );

    void deleteAdvertisement(Long advertisementId);

    AdminAdvertisementDetailsResponse getAdvertisementDetails(Long advertisementId);
}
