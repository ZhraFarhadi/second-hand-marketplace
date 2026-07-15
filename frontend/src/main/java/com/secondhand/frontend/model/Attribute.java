package com.secondhand.frontend.model;

import java.util.List;

public class Attribute {

    private final String name;

    private final AttributeType type;

    private final List<String> options;

    public Attribute(String name, AttributeType type) {

        this(name, type, List.of());

    }

    public Attribute(String name,
                     AttributeType type,
                     List<String> options) {

        this.name = name;
        this.type = type;
        this.options = options;

    }

    public String getName() {

        return name;

    }

    public AttributeType getType() {

        return type;

    }

    public List<String> getOptions() {

        return options;

    }

}