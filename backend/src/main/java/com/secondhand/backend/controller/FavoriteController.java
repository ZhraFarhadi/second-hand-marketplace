package com.secondhand.backend.controller;

import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.service.interfaces.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/{advertisementId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void toggleFavorite(
            @PathVariable
            Long advertisementId
    ) {

        favoriteService.toggleFavorite(
                advertisementId
        );

    }

    @GetMapping
    public Page<AdvertisementSummaryResponse> getMyFavorites(
            Pageable pageable
    ) {

        return favoriteService.getMyFavorites(
                pageable
        );

    }

}
