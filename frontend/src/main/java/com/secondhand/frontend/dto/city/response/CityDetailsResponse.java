package com.secondhand.frontend.dto.city.response;

public class CityDetailsResponse {

    private Long id;

    private String name;

    public CityDetailsResponse() {
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
}