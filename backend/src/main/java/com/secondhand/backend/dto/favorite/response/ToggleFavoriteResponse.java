package com.secondhand.backend.dto.favorite.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToggleFavoriteResponse {

    private Long advertisementId;

    @JsonProperty("isFavorite")
    private boolean isFavorite;
}
