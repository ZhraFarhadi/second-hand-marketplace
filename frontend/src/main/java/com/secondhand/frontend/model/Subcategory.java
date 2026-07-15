package com.secondhand.frontend.model;

public class Subcategory {

    private final String name;

    public Subcategory(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    @Override
    public String toString() {

        return name;

    }


}