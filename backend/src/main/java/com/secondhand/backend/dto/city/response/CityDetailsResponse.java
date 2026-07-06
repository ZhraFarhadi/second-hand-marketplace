package com.secondhand.backend.dto.city.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CityDetailsResponse {

    private Long id;

    private String name;

    private Long provinceId;

}