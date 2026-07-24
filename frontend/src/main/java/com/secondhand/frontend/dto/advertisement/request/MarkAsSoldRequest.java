package com.secondhand.frontend.dto.advertisement.request;

public class MarkAsSoldRequest {

    private Long buyerId;

    public MarkAsSoldRequest() {
    }

    public MarkAsSoldRequest(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}