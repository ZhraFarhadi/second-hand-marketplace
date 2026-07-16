package com.secondhand.backend.dto.city.response;

import com.secondhand.backend.dto.province.response.ProvinceResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CityDetailsResponse {

    private Long id;

    private String name;

    private ProvinceResponse province;

}