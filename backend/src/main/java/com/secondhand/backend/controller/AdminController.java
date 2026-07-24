package com.secondhand.backend.controller;

import com.secondhand.backend.dto.admin.request.CreateAdminReviewRequest;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementSummaryResponse;
import com.secondhand.backend.dto.admin.response.AdminReviewResponse;
import com.secondhand.backend.service.interfaces.AdminReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminReviewService adminService;



    @GetMapping("/reviews/pending")
    public Page<AdminAdvertisementSummaryResponse> getPendingAdvertisements(
            Pageable pageable
    ) {
        return adminService.getPendingAdvertisements(pageable);
    }


    @GetMapping("/advertisements/{advertisementId}")
    public AdminAdvertisementDetailsResponse getAdvertisementDetails(
            @PathVariable Long advertisementId
    ) {
        return adminService.getAdvertisementDetails(advertisementId);
    }



    @PostMapping("/advertisements/{advertisementId}/review")
    public AdminReviewResponse reviewAdvertisement(

            @PathVariable
            Long advertisementId,

            @Valid
            @RequestBody
            CreateAdminReviewRequest request
    ) {

        return adminService.reviewAdvertisement(
                advertisementId,
                request
        );

    }

    @GetMapping("/advertisements/{advertisementId}/reviews")
    public Page<AdminReviewResponse> getAdvertisementReviews(

            @PathVariable
            Long advertisementId,

            Pageable pageable
    ) {

        return adminService.getAdvertisementReviews(
                advertisementId,
                pageable
        );

    }

    @GetMapping("/advertisements")
    public Page<AdminAdvertisementSummaryResponse> getAllAdvertisements(
            Pageable pageable
    ) {
        return adminService.getAllAdvertisements(pageable);
    }

    @DeleteMapping("/advertisements/{advertisementId}")
    public void deleteAdvertisement(
            @PathVariable Long advertisementId
    ) {
        adminService.deleteAdvertisement(advertisementId);
    }

}