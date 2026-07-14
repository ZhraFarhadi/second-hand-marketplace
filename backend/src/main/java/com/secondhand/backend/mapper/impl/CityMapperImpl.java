package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.city.response.CitySummaryResponse;
import com.secondhand.backend.entity.City;
import com.secondhand.backend.mapper.interfaces.CityMapper;
import org.springframework.stereotype.Component;

@Component
public class CityMapperImpl implements CityMapper {

    @Override
    public CitySummaryResponse toSummaryResponse(City city) {

        if (city == null) {
            return null;
        }

        return new CitySummaryResponse(
                city.getId(),
                city.getName()
        );
    }
}