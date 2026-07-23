package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.province.response.ProvinceResponse;
import com.secondhand.frontend.service.ProvinceService;

import java.util.List;

public class ProvinceRepository {

    private static final ProvinceRepository INSTANCE =
            new ProvinceRepository();

    private final ProvinceService service =
            ProvinceService.getInstance();

    private ProvinceRepository() {
    }

    public static ProvinceRepository getInstance() {
        return INSTANCE;
    }

    public List<ProvinceResponse> getProvinces()
            throws Exception {

        return service.getProvinces();

    }

}