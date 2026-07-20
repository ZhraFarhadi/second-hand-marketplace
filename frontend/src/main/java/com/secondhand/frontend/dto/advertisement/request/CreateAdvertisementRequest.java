package com.secondhand.frontend.dto.advertisement.request;

import java.math.BigDecimal;
import java.util.List;

public class CreateAdvertisementRequest {

    private String title;

    private String description;

    private BigDecimal price;

    private Long categoryId;

    private Long cityId;

    private List<AdvertisementImageRequest> images;

    private List<AdvertisementAttributeRequest> attributes;

    public CreateAdvertisementRequest() {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public List<AdvertisementImageRequest> getImages() {
        return images;
    }

    public void setImages(List<AdvertisementImageRequest> images) {
        this.images = images;
    }

    public List<AdvertisementAttributeRequest> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AdvertisementAttributeRequest> attributes) {
        this.attributes = attributes;
    }
}