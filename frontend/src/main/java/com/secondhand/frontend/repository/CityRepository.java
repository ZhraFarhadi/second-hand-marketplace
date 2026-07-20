package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.city.response.CitySummaryResponse;
import com.secondhand.frontend.service.CityService;

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

    public List<CitySummaryResponse> getCities()
            throws Exception {

        return service.getCities();

    }

}