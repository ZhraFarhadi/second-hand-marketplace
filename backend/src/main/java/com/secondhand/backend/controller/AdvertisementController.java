package com.secondhand.backend.controller;

import com.secondhand.backend.dto.advertisement.request.*;

import com.secondhand.backend.dto.advertisement.response.*;

import com.secondhand.backend.service.interfaces.AdvertisementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/advertisements")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @PostMapping
    public ResponseEntity<AdvertisementDetailsResponse> create(
            @Valid @RequestBody CreateAdvertisementRequest request
    ) {

        AdvertisementDetailsResponse response =
                advertisementService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }

    @PutMapping("/{advertisementId}")
    public AdvertisementDetailsResponse update(
            @PathVariable Long advertisementId,
            @Valid @RequestBody UpdateAdvertisementRequest request
    ) {

        return advertisementService.update(
                advertisementId,
                request
        );

    }

    @DeleteMapping("/{advertisementId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long advertisementId
    ) {

        advertisementService.delete(advertisementId);

    }

    @PatchMapping("/{advertisementId}/sold")
    public AdvertisementDetailsResponse markAsSold(
            @PathVariable Long advertisementId,
            @Valid @RequestBody MarkAsSoldRequest request
    ) {
        return advertisementService.markAsSold(
                advertisementId,
                request
        );
    }

    @GetMapping("/{advertisementId}")
    public AdvertisementDetailsResponse getDetails(
            @PathVariable Long advertisementId
    ) {

        return advertisementService.getAdvertisementDetails(
                advertisementId
        );

    }

    @GetMapping
    public Page<AdvertisementSummaryResponse> getAdvertisements(
            Pageable pageable
    ) {

        return advertisementService.getAdvertisements(pageable);

    }


    @GetMapping("/my")
    public Page<MyAdvertisementSummaryResponse> getMyAdvertisements(
            Pageable pageable
    ) {

        return advertisementService.getMyAdvertisements(pageable);

    }
}


