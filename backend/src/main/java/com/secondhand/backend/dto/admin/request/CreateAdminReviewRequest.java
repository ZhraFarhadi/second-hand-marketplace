package com.secondhand.backend.dto.admin.request;

import com.secondhand.backend.enums.AdvertisementStatus;
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
public class CreateAdminReviewRequest {

    @NotNull(message = "Status is required.")
    private AdvertisementStatus status;

    @NotBlank(message = "Comment is required.")
    @Size(max = 1000,
            message = "Comment must not exceed 1000 characters.")
    private String comment;

}