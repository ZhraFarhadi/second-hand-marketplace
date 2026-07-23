package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.dto.favorite.response.ToggleFavoriteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteService {

    ToggleFavoriteResponse toggleFavorite(Long advertisementId);


    Page<AdvertisementSummaryResponse> getMyFavorites(
            Pageable pageable
    );

}
