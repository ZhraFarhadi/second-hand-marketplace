package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.city.response.CityDetailsResponse;
import com.secondhand.backend.dto.city.response.CitySummaryResponse;
import com.secondhand.backend.dto.province.response.ProvinceResponse;
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

    @Override
    public CityDetailsResponse toDetailsResponse(
            City city
    ) {

        if (city == null) {
            return null;
        }

        return new CityDetailsResponse(
                city.getId(),
                city.getName(),
                new ProvinceResponse(
                        city.getProvince().getId(),
                        city.getProvince().getName()
                )
        );

    }
}