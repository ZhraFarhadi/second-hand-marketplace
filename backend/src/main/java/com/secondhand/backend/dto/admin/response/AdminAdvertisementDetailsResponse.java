package com.secondhand.backend.dto.admin.response;

import com.secondhand.backend.dto.advertisement.response.AdvertisementAttributeResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementImageResponse;
import com.secondhand.backend.enums.AdvertisementStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AdminAdvertisementDetailsResponse {

    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private AdvertisementStatus status;

    private Long sellerId;

    private String sellerUsername;

    private String sellerFullName;

    private Long buyerId;

    private String buyerUsername;

    private Long categoryId;

    private String categoryName;

    private Long cityId;

    private String cityName;

    private List<AdvertisementImageResponse> images;

    private List<AdvertisementAttributeResponse> attributes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
