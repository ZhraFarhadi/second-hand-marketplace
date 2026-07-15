package com.secondhand.frontend.model;

import java.util.List;

public class Category {

    private final String name;

    private final List<Subcategory> subcategories;

    public Category(String name, List<Subcategory> subcategories) {

        this.name = name;
        this.subcategories = subcategories;

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