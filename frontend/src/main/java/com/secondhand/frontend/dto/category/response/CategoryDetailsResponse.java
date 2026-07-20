package com.secondhand.frontend.dto.category.response;

import java.util.List;

public class CategoryDetailsResponse {

    private Long id;

    private String name;

    private Long parentId;

    private List<CategorySummaryResponse> children;

    private List<CategoryAttributeResponse> attributes;

    public CategoryDetailsResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<CategorySummaryResponse> getChildren() {
        return children;
    }

    public void setChildren(List<CategorySummaryResponse> children) {
        this.children = children;
    }

    public List<CategoryAttributeResponse> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CategoryAttributeResponse> attributes) {
        this.attributes = attributes;
    }
}