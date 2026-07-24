package com.secondhand.frontend.dto.city.response;

import com.secondhand.frontend.dto.province.response.ProvinceResponse;

public class CityDetailsResponse {

    private Long id;

    private String name;

    private ProvinceResponse province;

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

    public ProvinceResponse getProvince() {
        return province;
    }

    public void setProvince(ProvinceResponse province) {
        this.province = province;
    }
}