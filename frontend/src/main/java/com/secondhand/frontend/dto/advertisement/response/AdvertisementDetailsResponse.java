package com.secondhand.frontend.dto.advertisement.response;

import com.secondhand.frontend.dto.auth.response.UserSummaryResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.dto.city.response.CitySummaryResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean favorite;

    private boolean owner;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }
}