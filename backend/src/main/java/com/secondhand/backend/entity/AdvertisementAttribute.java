package com.secondhand.backend.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "advertisement_attributes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "advertisement_id",
                        "category_attribute_id"
                })
        }
)
public class AdvertisementAttribute extends BaseEntity {

    @Column(name = "value", nullable = false, length = 255)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_id", nullable = false)
    private Advertisement advertisement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_attribute_id", nullable = false)
    private CategoryAttribute categoryAttribute;

}