package com.secondhand.frontend.dto.advertisement.response;

import com.secondhand.frontend.dto.auth.response.UserSummaryResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.dto.city.response.CitySummaryResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AdvertisementSummaryResponse {

    private Long id;

    private String title;

    private BigDecimal price;

    private String primaryImageUrl;

    private CategorySummaryResponse category;

    private UserSummaryResponse seller;

    private CitySummaryResponse city;

    private LocalDateTime createdAt;

    public AdvertisementSummaryResponse() {
    }

    public AdvertisementSummaryResponse(
            Long id,
            String title,
            BigDecimal price,
            String primaryImageUrl,
            CategorySummaryResponse category,
            UserSummaryResponse seller,
            CitySummaryResponse city
    ) {

        this.id = id;
        this.title = title;
        this.price = price;
        this.primaryImageUrl = primaryImageUrl;
        this.category = category;
        this.seller = seller;
        this.city = city;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPrimaryImageUrl() {
        return primaryImageUrl;
    }

    public void setPrimaryImageUrl(String primaryImageUrl) {
        this.primaryImageUrl = primaryImageUrl;
    }

    public CategorySummaryResponse getCategory() {
        return category;
    }

    public void setCategory(CategorySummaryResponse category) {
        this.category = category;
    }

    public UserSummaryResponse getSeller() {
        return seller;
    }

    public void setSeller(UserSummaryResponse seller) {
        this.seller = seller;
    }

    public CitySummaryResponse getCity() {
        return city;
    }

    public void setCity(CitySummaryResponse city) {
        this.city = city;
    }

    public LocalDateTime getCreatedAt(){return createdAt;}


    private boolean favorite;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

}