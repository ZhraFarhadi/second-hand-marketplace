package com.secondhand.frontend.dto.advertisement.response;

import com.secondhand.frontend.dto.auth.response.UserSummaryResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.dto.city.response.CitySummaryResponse;

import java.math.BigDecimal;
import java.util.List;

public class AdvertisementDetailsResponse {

    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private String status;

    private UserSummaryResponse seller;

    private CategorySummaryResponse category;

    private CitySummaryResponse city;

    private List<AdvertisementImageResponse> images;

    private List<AdvertisementAttributeResponse> attributes;

    private String createdAt;

    private String updatedAt;

    public AdvertisementDetailsResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserSummaryResponse getSeller() {
        return seller;
    }

    public void setSeller(UserSummaryResponse seller) {
        this.seller = seller;
    }

    public CategorySummaryResponse getCategory() {
        return category;
    }

    public void setCategory(CategorySummaryResponse category) {
        this.category = category;
    }

    public CitySummaryResponse getCity() {
        return city;
    }

    public void setCity(CitySummaryResponse city) {
        this.city = city;
    }

    public List<AdvertisementImageResponse> getImages() {
        return images;
    }

    public void setImages(List<AdvertisementImageResponse> images) {
        this.images = images;
    }

    public List<AdvertisementAttributeResponse> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AdvertisementAttributeResponse> attributes) {
        this.attributes = attributes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}