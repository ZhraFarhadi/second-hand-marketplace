package com.secondhand.backend.controller;

import com.secondhand.backend.dto.city.response.CitySummaryResponse;
import com.secondhand.backend.dto.province.response.ProvinceResponse;
import com.secondhand.backend.service.interfaces.CityService;
import com.secondhand.backend.service.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
@RequiredArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;
    private final CityService cityService;

    @GetMapping
    public List<ProvinceResponse> getProvinces() {

        return provinceService.getProvinces();

    }

    @GetMapping("/{provinceId}/cities")
    public List<CitySummaryResponse> getCitiesByProvince(
            @PathVariable
            Long provinceId
    ) {

        return cityService.getCitiesByProvince(
                provinceId
        );

    }

}