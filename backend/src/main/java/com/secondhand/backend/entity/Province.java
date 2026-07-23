package com.secondhand.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "provinces")
public class Province extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy = "province")
    private List<City> cities = new ArrayList<>();

    @Column(name = "code", nullable = false, unique = true, length = 10)
    private String code;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder = 0;
}