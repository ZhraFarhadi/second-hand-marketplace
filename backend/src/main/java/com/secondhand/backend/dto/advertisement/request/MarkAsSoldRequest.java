package com.secondhand.backend.dto.advertisement.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkAsSoldRequest {

    @NotNull(message = "Buyer id is required.")
    private Long buyerId;

}