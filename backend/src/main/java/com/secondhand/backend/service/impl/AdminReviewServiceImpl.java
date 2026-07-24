package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.admin.request.CreateAdminReviewRequest;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminReviewResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.entity.AdminReview;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AdvertisementStatus;
import com.secondhand.backend.enums.ReviewStatus;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.AdminReviewMapper;
import com.secondhand.backend.mapper.interfaces.AdvertisementMapper;
import com.secondhand.backend.repository.AdminReviewRepository;
import com.secondhand.backend.repository.AdvertisementRepository;
import com.secondhand.backend.service.interfaces.AdminReviewService;
import com.secondhand.backend.service.interfaces.CurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.backend.entity.Advertisement;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminReviewServiceImpl
        implements AdminReviewService {

    private final AdvertisementRepository advertisementRepository;

    private final AdminReviewRepository adminReviewRepository;

    private final AdvertisementMapper advertisementMapper;

    private final AdminReviewMapper adminReviewMapper;

    private final CurrentUserService currentUserService;


    @Override
    public AdminAdvertisementDetailsResponse getAdvertisementDetails(
            Long advertisementId
    ) {

        Advertisement advertisement =
                advertisementRepository.findById(advertisementId)
                        .orElseThrow(() ->
                                new RuntimeException("Advertisement not found"));

        return advertisementMapper.toAdminDetailsResponse(advertisement);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdvertisementSummaryResponse> getPendingAdvertisements(
            Pageable pageable
    ) {

        return advertisementRepository
                .findByStatusAndDeletedAtIsNullOrderByCreatedAtDesc(
                        AdvertisementStatus.PENDING,
                        pageable
                )
                .map(advertisementMapper::toSummaryResponse);

    }

    @Override
    public AdminReviewResponse reviewAdvertisement(
            Long advertisementId,
            CreateAdminReviewRequest request
    ) {

        Advertisement advertisement =
                getPendingAdvertisement(advertisementId);

        User admin =
                currentUserService.getCurrentUser();

        updateAdvertisementStatus(
                advertisement,
                request.getReviewStatus()
        );

        AdminReview review =
                buildReview(
                        advertisement,
                        admin,
                        request
                );

        advertisementRepository.save(advertisement);

        AdminReview savedReview =
                adminReviewRepository.save(review);

        return adminReviewMapper.toResponse(savedReview);

    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdminReviewResponse> getAdvertisementReviews(
            Long advertisementId,
            Pageable pageable
    ) {

        Advertisement advertisement =
                getAdvertisement(advertisementId);

        return adminReviewRepository
                .findByAdvertisementOrderByReviewedAtDesc(
                        advertisement,
                        pageable
                )
                .map(adminReviewMapper::toResponse);

    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdminReviewResponse> getMyReviews(
            Pageable pageable
    ) {

        User admin =
                currentUserService.getCurrentUser();

        return adminReviewRepository
                .findByAdminOrderByReviewedAtDesc(
                        admin,
                        pageable
                )
                .map(adminReviewMapper::toResponse);

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

    private Advertisement getPendingAdvertisement(
            Long advertisementId
    ) {

        Advertisement advertisement =
                getAdvertisement(advertisementId);

        if (advertisement.getStatus()
                != AdvertisementStatus.PENDING) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_NOT_PENDING
            );

        }

        return advertisement;

    }

    private void updateAdvertisementStatus(
            Advertisement advertisement,
            ReviewStatus reviewStatus
    ) {

        if (reviewStatus == ReviewStatus.APPROVED) {

            advertisement.setStatus(
                    AdvertisementStatus.ACTIVE
            );

        } else {

            advertisement.setStatus(
                    AdvertisementStatus.REJECTED
            );

        }

    }

    private AdminReview buildReview(
            Advertisement advertisement,
            User admin,
            CreateAdminReviewRequest request
    ) {

        AdminReview review =
                new AdminReview();

        review.setAdvertisement(advertisement);

        review.setAdmin(admin);

        review.setReviewStatus(
                request.getReviewStatus()
        );

        review.setComment(
                request.getComment().trim()
        );

        review.setReviewedAt(
                LocalDateTime.now()
        );

        return review;

    }

}
