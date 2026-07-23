package com.secondhand.backend.dto.admin.response;

import com.secondhand.backend.enums.AdvertisementStatus;
import com.secondhand.backend.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AdminReviewResponse {

    private Long id;

    private String adminUsername;

//    private AdvertisementStatus status;
    private ReviewStatus reviewStatus;

    private String comment;

//    private LocalDateTime createdAt;
    private LocalDateTime reviewedAt;

    private long advertisementId;

}