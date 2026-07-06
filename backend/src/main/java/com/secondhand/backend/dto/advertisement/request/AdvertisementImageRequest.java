package com.secondhand.backend.dto.advertisement.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementImageRequest {

    @NotBlank(message = "Image URL is required.")
    @Size(max = 500, message = "Image URL must not exceed 500 characters.")
    private String imageUrl;

    private boolean primary;

}
