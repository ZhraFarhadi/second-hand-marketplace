package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.city.response.CitySummaryResponse;
import com.secondhand.frontend.service.CityService;
import com.secondhand.frontend.dto.city.response.CityDetailsResponse;
import java.util.List;

public class CityRepository {

    private static final CityRepository INSTANCE =
            new CityRepository();

    private final CityService service =
            CityService.getInstance();

    private CityRepository() {
    }

    public static CityRepository getInstance() {
        return INSTANCE;
    }

    public List<CitySummaryResponse> getCitiesByProvince(
            Long provinceId
    ) throws Exception {

        return service.getCitiesByProvince(provinceId);

    }

    public CityDetailsResponse getCityDetails(Long cityId)
            throws Exception {

        return service.getCityDetails(cityId);
    }

}