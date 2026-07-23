package com.secondhand.backend.controller;

import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.dto.favorite.response.ToggleFavoriteResponse;
import com.secondhand.backend.service.interfaces.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/{advertisementId}")
    public ToggleFavoriteResponse toggleFavorite(
            @PathVariable Long advertisementId
    ) {
        return favoriteService.toggleFavorite(advertisementId);
    }

    @GetMapping
    public Page<AdvertisementSummaryResponse> getMyFavorites(Pageable pageable) {
        return favoriteService.getMyFavorites(pageable);
    }
}
