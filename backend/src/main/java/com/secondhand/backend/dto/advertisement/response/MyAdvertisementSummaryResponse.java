package com.secondhand.backend.dto.advertisement.response;


import com.secondhand.backend.enums.AdvertisementStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MyAdvertisementSummaryResponse {

    private Long id;

    private String title;

    private BigDecimal price;

    private AdvertisementStatus status;

    private String primaryImageUrl;

    private LocalDateTime createdAt;


    private String rejectionReason;

}