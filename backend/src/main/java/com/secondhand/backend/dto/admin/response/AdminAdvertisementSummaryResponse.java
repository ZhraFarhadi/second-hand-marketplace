package com.secondhand.backend.dto.admin.response;

import com.secondhand.backend.enums.AdvertisementStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AdminAdvertisementSummaryResponse {

    private Long id;

    private String title;

    private BigDecimal price;

    private AdvertisementStatus status;

    private String sellerUsername;

    private String categoryName;

    private String cityName;

    private LocalDateTime createdAt;

}