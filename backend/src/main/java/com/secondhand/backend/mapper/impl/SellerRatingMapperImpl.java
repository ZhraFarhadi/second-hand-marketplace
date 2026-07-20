package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.rating.response.SellerRatingResponse;
import com.secondhand.backend.entity.SellerRating;
import com.secondhand.backend.mapper.interfaces.SellerRatingMapper;
import com.secondhand.backend.mapper.interfaces.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellerRatingMapperImpl
        implements SellerRatingMapper {

    private final UserMapper userMapper;

    @Override
    public SellerRatingResponse toResponse(
            SellerRating sellerRating
    ) {

        if (sellerRating == null) {
            return null;
        }

        return new SellerRatingResponse(
                sellerRating.getId(),
                sellerRating.getRating(),      // Entity.rating -> DTO.score
                sellerRating.getComment(),
                userMapper.toSummaryResponse(
                        sellerRating.getReviewer()
                ),
                sellerRating.getCreatedAt(),
                sellerRating.getAdvertisement().getId()
        );

    }

}