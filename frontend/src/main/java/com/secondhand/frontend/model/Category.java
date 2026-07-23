package com.secondhand.frontend.model;

import java.util.List;

public class Category {

    private final Long id;

    private final String name;

    private final List<Subcategory> subcategories;

    public Category(
            Long id,
            String name,
            List<Subcategory> subcategories
    ) {

        this.id = id;
        this.name = name;
        this.subcategories = subcategories;

    }

    public Long getId() {

        return id;

    }

    public String getName() {

        return name;

    }

    public List<Subcategory> getSubcategories() {

        return subcategories;

    }

    @Override
    public String toString() {

        return name;

    }

}