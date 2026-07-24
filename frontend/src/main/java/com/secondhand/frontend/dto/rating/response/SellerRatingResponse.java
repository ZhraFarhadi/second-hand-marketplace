package com.secondhand.frontend.dto.rating.response;

import com.secondhand.frontend.dto.auth.response.UserSummaryResponse;

import java.time.LocalDateTime;

public class SellerRatingResponse {

    private Long id;

    private Integer score;

    private String comment;

    private UserSummaryResponse reviewer;

    private LocalDateTime createdAt;

    private Long advertisementId;

    public Long getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public UserSummaryResponse getReviewer() {
        return reviewer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getAdvertisementId() {
        return advertisementId;
    }
}