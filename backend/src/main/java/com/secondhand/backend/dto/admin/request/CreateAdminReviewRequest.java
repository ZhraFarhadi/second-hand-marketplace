package com.secondhand.backend.dto.admin.request;

import com.secondhand.backend.enums.AdvertisementStatus;
import com.secondhand.backend.enums.ReviewStatus;
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

    @NotNull(message = "Review status is required.")
    private ReviewStatus reviewStatus;

    @NotBlank(message = "Comment is required.")
    @Size(max = 1000)
    private String comment;

}