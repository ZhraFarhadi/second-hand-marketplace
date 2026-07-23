package com.secondhand.frontend.dto.admin.request;

import com.secondhand.frontend.model.ReviewStatus;

public class CreateAdminReviewRequest {

    private ReviewStatus reviewStatus;

    private String comment;

    public CreateAdminReviewRequest() {
    }

    public CreateAdminReviewRequest(
            ReviewStatus reviewStatus,
            String comment
    ) {
        this.reviewStatus = reviewStatus;
        this.comment = comment;
    }

    public ReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(
            ReviewStatus reviewStatus
    ) {
        this.reviewStatus = reviewStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(
            String comment
    ) {
        this.comment = comment;
    }
}