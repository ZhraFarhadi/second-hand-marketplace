package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.admin.response.AdminDashboardResponse;
import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.AdvertisementStatus;
import com.secondhand.backend.repository.*;
import com.secondhand.backend.service.interfaces.AdminDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminDashboardServiceImpl
        implements AdminDashboardService {

    private final UserRepository userRepository;

    private final AdvertisementRepository advertisementRepository;

    private final CategoryRepository categoryRepository;

    private final CityRepository cityRepository;

    private final ProvinceRepository provinceRepository;

    private final SellerRatingRepository sellerRatingRepository;

    private final ConversationRepository conversationRepository;

    @Override
    public AdminDashboardResponse getDashboard() {

        return new AdminDashboardResponse(

                userRepository.count(),

                userRepository.countByAccountStatus(
                        AccountStatus.BLOCKED
                ),

                advertisementRepository.countByDeletedAtIsNull(),

                advertisementRepository.countByStatusAndDeletedAtIsNull(
                        AdvertisementStatus.PENDING
                ),

                advertisementRepository.countByStatusAndDeletedAtIsNull(
                        AdvertisementStatus.ACTIVE
                ),

                advertisementRepository.countByStatusAndDeletedAtIsNull(
                        AdvertisementStatus.SOLD
                ),

                categoryRepository.count(),

                cityRepository.count(),

                provinceRepository.count(),

                sellerRatingRepository.count(),

                conversationRepository.count()

        );

    }

}
