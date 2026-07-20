package com.secondhand.backend.controller;

import com.secondhand.backend.dto.rating.request.CreateSellerRatingRequest;
import com.secondhand.backend.dto.rating.response.SellerRatingResponse;
import com.secondhand.backend.service.interfaces.SellerRatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ratings")
public class SellerRatingController {

    private final SellerRatingService sellerRatingService;

    @PostMapping("/advertisements/{advertisementId}")
    @ResponseStatus(HttpStatus.CREATED)
    public SellerRatingResponse create(
            @PathVariable Long advertisementId,
            @Valid
            @RequestBody CreateSellerRatingRequest request
    ) {

        return sellerRatingService.create(
                advertisementId,
                request
        );

    }

    @GetMapping("/seller/{sellerId}")
    public Page<SellerRatingResponse> getSellerRatings(
            @PathVariable Long sellerId,
            Pageable pageable
    ) {

        return sellerRatingService.getSellerRatings(
                sellerId,
                pageable
        );

    }

}
