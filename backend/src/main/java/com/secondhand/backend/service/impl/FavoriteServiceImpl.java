package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.dto.favorite.response.ToggleFavoriteResponse;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.Favorite;
import com.secondhand.backend.entity.User;
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

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final AdvertisementRepository advertisementRepository;
    private final CurrentUserService currentUserService;
    private final AdvertisementMapper advertisementMapper;

    @Override
    public ToggleFavoriteResponse toggleFavorite(Long advertisementId) {
        User currentUser = currentUserService.getCurrentUser();

        Advertisement advertisement = getAdvertisementOrThrow(advertisementId);
        validateAdvertisementCanBeFavorited(advertisement, currentUser);

        Optional<Favorite> existingFavorite =
                favoriteRepository.findByUserAndAdvertisement(currentUser, advertisement);

        if (existingFavorite.isPresent()) {
            favoriteRepository.delete(existingFavorite.get());
            return new ToggleFavoriteResponse(advertisement.getId(), false);
        }

        Favorite favorite = buildFavorite(currentUser, advertisement);
        favoriteRepository.save(favorite);

        return new ToggleFavoriteResponse(advertisement.getId(), true);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdvertisementSummaryResponse> getMyFavorites(Pageable pageable) {
        User currentUser = currentUserService.getCurrentUser();

        return favoriteRepository
                .findActiveFavoritesByUserOrderByCreatedAtDesc(
                        currentUser,
                        AdvertisementStatus.ACTIVE,
                        pageable
                )
                .map(Favorite::getAdvertisement)
                .map(advertisement -> advertisementMapper.toSummaryResponse(
                        advertisement,
                        true,
                        false
                ));
    }

    private Advertisement getAdvertisementOrThrow(Long advertisementId) {
        return advertisementRepository.findById(advertisementId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ADVERTISEMENT_NOT_FOUND));
    }

    private void validateAdvertisementCanBeFavorited(
            Advertisement advertisement,
            User currentUser
    ) {
        if (advertisement.getDeletedAt() != null
                || advertisement.getStatus() != AdvertisementStatus.ACTIVE) {
            throw new BusinessException(ErrorCode.ADVERTISEMENT_NOT_FOUND);
        }

        if (advertisement.getSeller().getId().equals(currentUser.getId())) {
            throw new BusinessException(ErrorCode.CANNOT_FAVORITE_OWN_ADVERTISEMENT);
        }
    }

    private Favorite buildFavorite(User user, Advertisement advertisement) {
        Favorite favorite = new Favorite();
        user.addFavorite(favorite);
        advertisement.addFavorite(favorite);
        return favorite;
    }
}
