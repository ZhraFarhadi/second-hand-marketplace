package com.secondhand.backend.dto.rating.response;

import com.secondhand.backend.dto.auth.response.UserSummaryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SellerRatingResponse {

    private Long id;

    private Integer score;

    private String comment;

    private UserSummaryResponse reviewer;

    private LocalDateTime createdAt;

    private Long advertisementId;

}