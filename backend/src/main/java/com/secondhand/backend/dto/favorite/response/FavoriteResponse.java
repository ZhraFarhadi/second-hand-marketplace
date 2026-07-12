
package com.secondhand.backend.dto.favorite.response;

import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FavoriteResponse {

    private Long id;

    private AdvertisementSummaryResponse advertisement;

}