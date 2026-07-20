package com.secondhand.frontend.dto.advertisement.request;

public class AdvertisementAttributeRequest {

    private Long categoryAttributeId;

    private String value;

    public AdvertisementAttributeRequest() {
    }

    public Long getCategoryAttributeId() {
        return categoryAttributeId;
    }

    public void setCategoryAttributeId(Long categoryAttributeId) {
        this.categoryAttributeId = categoryAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}