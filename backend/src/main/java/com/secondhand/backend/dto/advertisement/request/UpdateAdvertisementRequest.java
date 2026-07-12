package com.secondhand.backend.dto.advertisement.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdvertisementRequest {

    @NotBlank(message = "Title is required.")
    @Size(max = 200, message = "Title must not exceed 200 characters.")
    private String title;

    @NotBlank(message = "Description is required.")
    private String description;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0", inclusive = false,
            message = "Price must be greater than zero.")
    private BigDecimal price;

    @NotNull(message = "Category is required.")
    private Long categoryId;

    @NotNull(message = "City is required.")
    private Long cityId;

    @NotEmpty(message = "At least one image is required.")
    @Valid
    private List<AdvertisementImageRequest> images;

    @Valid
    private List<AdvertisementAttributeRequest> attributes;

}