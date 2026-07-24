package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.admin.request.CreateAdminReviewRequest;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminReviewResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminReviewService {

    Page<AdvertisementSummaryResponse> getPendingAdvertisements(
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



    AdminAdvertisementDetailsResponse getAdvertisementDetails(Long advertisementId);
}
