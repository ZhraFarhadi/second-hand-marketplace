package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.admin.response.AdminReviewResponse;
import com.secondhand.backend.entity.AdminReview;
import com.secondhand.backend.mapper.interfaces.AdminReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminReviewMapperImpl
        implements AdminReviewMapper {

    @Override
    public AdminReviewResponse toResponse(
            AdminReview review
    ) {

        if (review == null) {
            return null;
        }

        return new AdminReviewResponse(
                review.getId(),
                review.getAdmin().getUsername(),
                review.getReviewStatus(),
                review.getComment(),
                review.getReviewedAt(),
                review.getAdvertisement().getId()
        );

    }

}
