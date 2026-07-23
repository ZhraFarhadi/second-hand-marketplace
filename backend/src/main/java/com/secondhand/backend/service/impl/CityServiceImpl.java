package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.city.response.CityDetailsResponse;
import com.secondhand.backend.dto.city.response.CitySummaryResponse;
import com.secondhand.backend.entity.City;
import com.secondhand.backend.entity.Province;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.CityMapper;
import com.secondhand.backend.repository.CityRepository;
import com.secondhand.backend.repository.ProvinceRepository;
import com.secondhand.backend.service.interfaces.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CityServiceImpl
        implements CityService {

    private final CityRepository cityRepository;

    private final ProvinceRepository provinceRepository;

    private final CityMapper cityMapper;

    @Override
    public List<CitySummaryResponse> getCitiesByProvince(
            Long provinceId
    ) {

        Province province = getProvinceOrThrow(provinceId);

        return cityRepository
                .findAllByProvinceOrderByDisplayOrderAscNameAsc(province)
                .stream()
                .map(cityMapper::toSummaryResponse)
                .toList();

    }

    @Override
    public CityDetailsResponse getCityDetails(
            Long cityId
    ) {

        City city = getCityOrThrow(cityId);

        return cityMapper.toDetailsResponse(city);

    }

    private Province getProvinceOrThrow(
            Long provinceId
    ) {

        return provinceRepository.findById(provinceId)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.PROVINCE_NOT_FOUND
                        ));

    }

    private City getCityOrThrow(
            Long cityId
    ) {

        return cityRepository.findById(cityId)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.CITY_NOT_FOUND
                        ));

    }

}
