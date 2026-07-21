package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.admin.response.AdminReviewResponse;
import com.secondhand.backend.entity.AdminReview;

public interface AdminReviewMapper {

    AdminReviewResponse toResponse(
            AdminReview review
    );

}
