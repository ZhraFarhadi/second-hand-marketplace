package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.city.response.CitySummaryResponse;
import com.secondhand.backend.entity.City;

public interface CityMapper {

    CitySummaryResponse toSummaryResponse(City city);

}