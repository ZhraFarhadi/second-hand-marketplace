package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.advertisement.response.AdvertisementAttributeResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementDetailsResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementImageResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.dto.advertisement.response.MyAdvertisementSummaryResponse;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.AdvertisementAttribute;
import com.secondhand.backend.entity.AdvertisementImage;
import com.secondhand.backend.mapper.interfaces.AdvertisementMapper;
import com.secondhand.backend.mapper.interfaces.CategoryMapper;
import com.secondhand.backend.mapper.interfaces.CityMapper;
import com.secondhand.backend.mapper.interfaces.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AdvertisementMapperImpl implements AdvertisementMapper {

    private final UserMapper userMapper;
    private final CategoryMapper categoryMapper;
    private final CityMapper cityMapper;



    @Override
    public AdminAdvertisementDetailsResponse toAdminDetailsResponse(
            Advertisement advertisement
    ) {

        if (advertisement == null) {
            return null;
        }

        return new AdminAdvertisementDetailsResponse(
                advertisement.getId(),
                advertisement.getTitle(),
                advertisement.getDescription(),
                advertisement.getPrice(),
                advertisement.getStatus(),

                advertisement.getSeller().getId(),
                advertisement.getSeller().getUsername(),
                advertisement.getSeller().getFullName(),

                advertisement.getBuyer() == null ? null : advertisement.getBuyer().getId(),
                advertisement.getBuyer() == null ? null : advertisement.getBuyer().getUsername(),

                advertisement.getCategory().getId(),
                advertisement.getCategory().getName(),

                advertisement.getCity().getId(),
                advertisement.getCity().getName(),

                advertisement.getImages()
                        .stream()
                        .map(this::mapImage)
                        .toList(),

                advertisement.getAttributes()
                        .stream()
                        .map(this::mapAttribute)
                        .toList(),

                advertisement.getCreatedAt(),
                advertisement.getUpdatedAt()
        );
    }


    @Override
    public AdvertisementDetailsResponse toDetailsResponse(
            Advertisement advertisement
    ) {
        return toDetailsResponse(advertisement, false, false);
    }


    @Override
    public AdvertisementDetailsResponse toDetailsResponse(
            Advertisement advertisement,
            boolean isFavorite,
            boolean isOwner
    ) {

        if (advertisement == null) {
            return null;
        }
        return new AdvertisementDetailsResponse(
                advertisement.getId(),
                advertisement.getTitle(),
                advertisement.getDescription(),
                advertisement.getPrice(),
                advertisement.getStatus(),
                userMapper.toSummaryResponse(advertisement.getSeller()),
                userMapper.toSummaryResponse(advertisement.getBuyer()),
                categoryMapper.toSummaryResponse(advertisement.getCategory()),
                cityMapper.toSummaryResponse(advertisement.getCity()),
                advertisement.getImages()
                        .stream()
                        .map(this::mapImage)
                        .toList(),
                advertisement.getAttributes()
                        .stream()
                        .map(this::mapAttribute)
                        .toList(),
                advertisement.getCreatedAt(),
                advertisement.getUpdatedAt(),
                isFavorite,
                isOwner
        );

    }


    @Override
    public AdvertisementSummaryResponse toSummaryResponse(
            Advertisement advertisement
    ) {
        return toSummaryResponse(advertisement, false, false);
    }

    @Override
    public AdvertisementSummaryResponse toSummaryResponse(
            Advertisement advertisement,
            boolean isFavorite,
            boolean isOwner
    ) {

        if (advertisement == null) {
            return null;
        }

        return new AdvertisementSummaryResponse(
                advertisement.getId(),
                advertisement.getTitle(),
                advertisement.getPrice(),
                getPrimaryImageUrl(advertisement.getImages()),
                categoryMapper.toSummaryResponse(advertisement.getCategory()),
                userMapper.toSummaryResponse(advertisement.getSeller()),
                cityMapper.toSummaryResponse(advertisement.getCity()),
                isFavorite,
                isOwner
        );
    }


    @Override
    public MyAdvertisementSummaryResponse toMySummaryResponse(
            Advertisement advertisement
    ) {

        if (advertisement == null) {
            return null;
        }

        return new MyAdvertisementSummaryResponse(
                advertisement.getId(),
                advertisement.getTitle(),
                advertisement.getPrice(),
                advertisement.getStatus(),
                getPrimaryImageUrl(advertisement.getImages()),
                advertisement.getCreatedAt()
        );
    }

    private AdvertisementImageResponse mapImage(
            AdvertisementImage image
    ) {

        return new AdvertisementImageResponse(
                image.getId(),
                image.getImageUrl(),
                image.getDisplayOrder(),
                image.isPrimary()
        );
    }

    private AdvertisementAttributeResponse mapAttribute(
            AdvertisementAttribute attribute
    ) {

        return new AdvertisementAttributeResponse(
                attribute.getCategoryAttribute().getId(),
                attribute.getCategoryAttribute().getName(),
                attribute.getCategoryAttribute().getDataType(),
                attribute.getValue()
        );
    }

    private String getPrimaryImageUrl(
            List<AdvertisementImage> images
    ) {

        return images.stream()
                .filter(AdvertisementImage::isPrimary)
                .findFirst()
                .map(AdvertisementImage::getImageUrl)
                .orElse(null);
    }

}
