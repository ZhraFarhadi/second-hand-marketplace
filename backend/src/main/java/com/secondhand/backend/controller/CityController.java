package com.secondhand.backend.controller;

import com.secondhand.backend.dto.city.response.CityDetailsResponse;
import com.secondhand.backend.dto.city.response.CitySummaryResponse;
import com.secondhand.backend.service.interfaces.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/{cityId}")
    public CityDetailsResponse getCityDetails(
            @PathVariable
            Long cityId
    ) {

        return cityService.getCityDetails(cityId);

    }
}