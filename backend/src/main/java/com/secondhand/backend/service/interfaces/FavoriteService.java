package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteService {

    void toggleFavorite(
            Long advertisementId
    );

    Page<AdvertisementSummaryResponse> getMyFavorites(
            Pageable pageable
    );

}
