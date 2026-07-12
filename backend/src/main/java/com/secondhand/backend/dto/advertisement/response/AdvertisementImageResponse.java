package com.secondhand.backend.dto.advertisement.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdvertisementImageResponse {

    private Long id;

    private String imageUrl;

    private Integer displayOrder;

    private boolean primary;

}