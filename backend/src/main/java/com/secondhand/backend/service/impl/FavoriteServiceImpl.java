package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.enums.AdvertisementStatus;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.AdvertisementMapper;
import com.secondhand.backend.repository.AdvertisementRepository;
import com.secondhand.backend.repository.FavoriteRepository;
import com.secondhand.backend.service.interfaces.CurrentUserService;
import com.secondhand.backend.service.interfaces.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.Favorite;
import com.secondhand.backend.entity.User;


@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteServiceImpl
        implements FavoriteService {

    private final FavoriteRepository favoriteRepository;

    private final AdvertisementRepository advertisementRepository;

    private final CurrentUserService currentUserService;

    private final AdvertisementMapper advertisementMapper;

    @Override
    public void toggleFavorite(
            Long advertisementId
    ) {

        User currentUser =
                currentUserService.getCurrentUser();

        Advertisement advertisement =
                getAdvertisementOrThrow(advertisementId);

        validateAdvertisementCanBeFavorited(
                advertisement
        );

        Favorite favorite =
                favoriteRepository
                        .findByUserAndAdvertisement(
                                currentUser,
                                advertisement
                        )
                        .orElse(null);

        if (favorite != null) {

            favoriteRepository.delete(favorite);

            return;
        }

        favoriteRepository.save(
                buildFavorite(
                        currentUser,
                        advertisement
                )
        );

    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdvertisementSummaryResponse> getMyFavorites(
            Pageable pageable
    ) {

        User currentUser =
                currentUserService.getCurrentUser();

        return favoriteRepository
                .findByUserAndAdvertisementDeletedAtIsNullOrderByCreatedAtDesc(
                        currentUser,
                        pageable
                )
                .map(Favorite::getAdvertisement)
                .map(advertisementMapper::toSummaryResponse);

    }


    private Advertisement getAdvertisementOrThrow(
            Long advertisementId
    ) {

        return advertisementRepository
                .findByIdAndDeletedAtIsNull(
                        advertisementId
                )
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.ADVERTISEMENT_NOT_FOUND
                        ));

    }

    private void validateAdvertisementCanBeFavorited(
            Advertisement advertisement
    ) {

        if (advertisement.getStatus()
                != AdvertisementStatus.ACTIVE) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_NOT_FOUND
            );

        }

    }

    private Favorite buildFavorite(
            User user,
            Advertisement advertisement
    ) {

        Favorite favorite =
                new Favorite();

        user.addFavorite(favorite);

        advertisement.addFavorite(favorite);

        return favorite;

    }

}