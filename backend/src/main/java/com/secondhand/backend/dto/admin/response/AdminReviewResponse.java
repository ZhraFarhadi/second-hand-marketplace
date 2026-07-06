package com.secondhand.backend.dto.admin.response;

import com.secondhand.backend.enums.AdvertisementStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AdminReviewResponse {

    private Long id;

    private String adminUsername;

    private AdvertisementStatus status;

    private String comment;

    private LocalDateTime createdAt;

    private long advertisementId;

}