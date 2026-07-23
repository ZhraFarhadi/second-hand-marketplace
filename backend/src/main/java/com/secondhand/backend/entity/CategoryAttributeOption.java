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
        name = "category_attribute_options",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "category_attribute_id",
                                "value"
                        }
                )
        }
)
public class CategoryAttributeOption
        extends BaseEntity {

    @Column(
            name = "value",
            nullable = false,
            length = 100
    )
    private String value;

    @Column(
            name = "display_order",
            nullable = false
    )
    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "category_attribute_id",
            nullable = false
    )
    private CategoryAttribute categoryAttribute;

}
