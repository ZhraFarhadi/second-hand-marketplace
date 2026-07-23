package com.secondhand.backend.entity;

import com.secondhand.backend.enums.AttributeDataType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "category_attributes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"category_id", "name"})
        }
)
public class CategoryAttribute extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "data_type", nullable = false)
    private AttributeDataType dataType;

    @Column(name = "required", nullable = false)
    private boolean required = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "categoryAttribute")
    private List<AdvertisementAttribute> advertisementAttributes = new ArrayList<>();

    @OneToMany(
            mappedBy = "categoryAttribute",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("displayOrder ASC")
    private List<CategoryAttributeOption> options =
            new ArrayList<>();

}