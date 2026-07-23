package com.secondhand.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "cities",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name", "province_id"})
        }
)
public class City extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", nullable = false)
    private Province province;

    @OneToMany(mappedBy = "city")
    private List<Advertisement> advertisements = new ArrayList<>();

    @Column(name = "code", nullable = false, unique = true, length = 10)
    private String code;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder = 0;

}