package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.rating.request.CreateSellerRatingRequest;
import com.secondhand.backend.dto.rating.response.SellerRatingResponse;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.SellerRating;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.AdvertisementStatus;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.SellerRatingMapper;
import com.secondhand.backend.repository.AdvertisementRepository;
import com.secondhand.backend.repository.SellerRatingRepository;
import com.secondhand.backend.repository.UserRepository;
import com.secondhand.backend.service.interfaces.CurrentUserService;
import com.secondhand.backend.service.interfaces.SellerRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerRatingServiceImpl
        implements SellerRatingService {

    private final SellerRatingRepository sellerRatingRepository;

    private final AdvertisementRepository advertisementRepository;

    private final UserRepository userRepository;

    private final CurrentUserService currentUserService;

    private final SellerRatingMapper sellerRatingMapper;

    @Override
    public SellerRatingResponse create(
            Long advertisementId,
            CreateSellerRatingRequest request
    ) {

        User reviewer =
                currentUserService.getCurrentUser();

        Advertisement advertisement =
                getAdvertisement(advertisementId);

        validateAdvertisementSold(advertisement);

        User seller =
                advertisement.getSeller();

        validateSeller(seller);

        validateBuyer(reviewer);

        validateBuyerIsNotSeller(
                reviewer,
                seller
        );

        validateBuyerOwnsAdvertisement(
                advertisement,
                reviewer
        );

        validateDuplicateRating(
                reviewer,
                advertisement
        );

        SellerRating rating =
                buildSellerRating(
                        advertisement,
                        reviewer,
                        request
                );

        SellerRating savedRating =
                sellerRatingRepository.save(rating);
        updateSellerStatistics(seller);

        return sellerRatingMapper.toResponse(
                savedRating
        );

    }

    @Override
    @Transactional(readOnly = true)
    public Page<SellerRatingResponse> getSellerRatings(
            Long sellerId,
            Pageable pageable
    ) {

        User seller =
                userRepository.findById(sellerId)
                        .orElseThrow(() ->
                                new BusinessException(
                                        ErrorCode.USER_NOT_FOUND
                                ));

        validateSeller(seller);

        return sellerRatingRepository
                .findBySellerOrderByCreatedAtDesc(
                        seller,
                        pageable
                )
                .map(sellerRatingMapper::toResponse);

    }

    private Advertisement getAdvertisement(
            Long advertisementId
    ) {

        return advertisementRepository
                .findByIdAndDeletedAtIsNull(advertisementId)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.ADVERTISEMENT_NOT_FOUND
                        )
                );

    }

    private void validateSeller(
            User seller
    ) {

        if (seller.getAccountStatus() != AccountStatus.ACTIVE) {

            throw new BusinessException(
                    ErrorCode.SELLER_ACCOUNT_NOT_ACTIVE
            );

        }

    }

    private void validateBuyer(
            User buyer
    ) {

        if (buyer.getAccountStatus() != AccountStatus.ACTIVE) {

            throw new BusinessException(
                    ErrorCode.BUYER_ACCOUNT_NOT_ACTIVE
            );

        }

    }

    private void validateBuyerIsNotSeller(
            User reviewer,
            User seller
    ) {

        if (reviewer.getId().equals(seller.getId())) {

            throw new BusinessException(
                    ErrorCode.CANNOT_RATE_YOURSELF
            );

        }

    }

    private void validateBuyerOwnsAdvertisement(
            Advertisement advertisement,
            User reviewer
    ) {

        User buyer = advertisement.getBuyer();

        if (buyer == null) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_NOT_PURCHASED
            );

        }

        if (!buyer.getId().equals(reviewer.getId())) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_NOT_PURCHASED
            );

        }

    }

    private void validateDuplicateRating(
            User reviewer,
            Advertisement advertisement
    ) {

        if (sellerRatingRepository.existsByReviewerAndAdvertisement(
                reviewer,
                advertisement
        )) {

            throw new BusinessException(
                    ErrorCode.RATING_ALREADY_EXISTS
            );

        }

    }


    private SellerRating buildSellerRating(
            Advertisement advertisement,
            User reviewer,
            CreateSellerRatingRequest request
    ) {

        SellerRating rating = new SellerRating();

        rating.setAdvertisement(advertisement);

        rating.setSeller(
                advertisement.getSeller()
        );

        rating.setReviewer(reviewer);

        rating.setRating(
                request.getScore()
        );

        rating.setComment(
                request.getComment() == null
                        ? null
                        : request.getComment().trim()
        );

        return rating;

    }

    private void updateSellerStatistics(
            User seller
    ) {

        Double average =
                sellerRatingRepository
                        .findAverageRatingBySeller(seller);

        long count =
                sellerRatingRepository
                        .countBySeller(seller);

        seller.setAverageRating(
                average == null ? 0.0 : average
        );

        seller.setRatingCount(count);

        userRepository.save(seller);
    }

    private void validateAdvertisementSold(
            Advertisement advertisement
    ) {

        if (advertisement.getStatus() != AdvertisementStatus.SOLD) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_NOT_PURCHASED
            );

        }

    }

}