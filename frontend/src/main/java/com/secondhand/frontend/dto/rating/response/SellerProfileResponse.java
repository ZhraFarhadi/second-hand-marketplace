package com.secondhand.frontend.dto.rating.response;

public class SellerProfileResponse {

    private Long id;

    private String fullName;

    private String username;

    private Double averageRating;

    private Long ratingCount;

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public Long getRatingCount() {
        return ratingCount;
    }
}