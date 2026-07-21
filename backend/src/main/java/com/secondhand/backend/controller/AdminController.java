package com.secondhand.backend.controller;

import com.secondhand.backend.dto.admin.request.CreateAdminReviewRequest;
import com.secondhand.backend.dto.admin.response.AdminReviewResponse;
import com.secondhand.backend.service.interfaces.AdminReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminReviewService adminService;

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

}