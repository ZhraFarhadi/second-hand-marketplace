package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.city.response.CityDetailsResponse;
import com.secondhand.backend.dto.city.response.CitySummaryResponse;

import java.util.List;

public interface CityService {

    List<CitySummaryResponse> getCitiesByProvince(
            Long provinceId
    );

    CityDetailsResponse getCityDetails(
            Long cityId
    );

}