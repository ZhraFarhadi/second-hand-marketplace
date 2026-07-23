package com.secondhand.frontend.dto.admin.response;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementAttributeResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementImageResponse;
import com.secondhand.frontend.model.AdvertisementStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    public AdminAdvertisementDetailsResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AdvertisementStatus getStatus() {
        return status;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Long getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public List<AdvertisementImageResponse> getImages() {
        return images;
    }

    public List<AdvertisementAttributeResponse> getAttributes() {
        return attributes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}