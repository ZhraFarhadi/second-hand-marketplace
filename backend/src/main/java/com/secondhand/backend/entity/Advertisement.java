package com.secondhand.backend.entity;

import com.secondhand.backend.enums.AdvertisementStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "advertisements")
public class Advertisement extends BaseEntity {

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false, precision = 15, scale = 0)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AdvertisementStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(
            mappedBy = "advertisement",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("displayOrder ASC")
    private List<AdvertisementImage> images = new ArrayList<>();

    @OneToMany(
            mappedBy = "advertisement",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
   // @OrderBy("categoryAttribute.name ASC")
    private List<AdvertisementAttribute> attributes = new ArrayList<>();


    @OneToMany(
            mappedBy = "advertisement",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AdminReview> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "advertisement")
    private List<Conversation> conversations = new ArrayList<>();

    @OneToMany(mappedBy = "advertisement")
    private List<SellerRating> sellerRatings = new ArrayList<>();

    @OneToMany(mappedBy = "advertisement")
    private List<Favorite> favorites = new ArrayList<>();

    public void addImage(AdvertisementImage image) {
        images.add(image);
        image.setAdvertisement(this);
    }

    public void removeImage(AdvertisementImage image) {
        images.remove(image);
        image.setAdvertisement(null);
    }

    public void addAttribute(AdvertisementAttribute attribute) {
        attributes.add(attribute);
        attribute.setAdvertisement(this);
    }

    public void removeAttribute(AdvertisementAttribute attribute) {
        attributes.remove(attribute);
        attribute.setAdvertisement(null);
    }

    public void addFavorite(Favorite favorite) {
        favorites.add(favorite);
        favorite.setAdvertisement(this);
    }

    public void removeFavorite(Favorite favorite) {
        favorites.remove(favorite);
        favorite.setAdvertisement(null);
    }



}