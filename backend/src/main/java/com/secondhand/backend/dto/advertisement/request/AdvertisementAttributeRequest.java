
package com.secondhand.backend.dto.advertisement.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementAttributeRequest {

    @NotNull(message = "Category attribute ID is required.")
    private Long categoryAttributeId;

    @NotBlank(message = "Attribute value is required.")
    @Size(max = 255, message = "Attribute value must not exceed 255 characters.")
    private String value;

}