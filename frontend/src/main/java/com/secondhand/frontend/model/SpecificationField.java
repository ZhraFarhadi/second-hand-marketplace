package com.secondhand.frontend.model;

import java.util.List;

public class SpecificationField {

    private String label;
    private AttributeType type;
    private List<String> options;

    public SpecificationField(String label, AttributeType type) {
        this.label = label;
        this.type = type;
    }

    public SpecificationField(String label,
                              AttributeType type,
                              List<String> options) {

        this.label = label;
        this.type = type;
        this.options = options;
    }

    public String getLabel() {
        return label;
    }

    public AttributeType getType() {
        return type;
    }

    public List<String> getOptions() {
        return options;
    }
}