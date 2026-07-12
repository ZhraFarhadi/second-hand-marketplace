package com.secondhand.backend.dto.rating.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class CreateSellerRatingRequest {

    @NotNull(message = "Score is required.")
    @Min(value = 1, message = "Score must be at least 1.")
    @Max(value = 5, message = "Score must not exceed 5.")
    private Integer score;

    @Size(max = 500,
            message = "Comment must not exceed 500 characters.")
    private String comment;

}