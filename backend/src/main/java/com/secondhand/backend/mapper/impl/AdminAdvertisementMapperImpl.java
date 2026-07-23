package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementSummaryResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementAttributeResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementImageResponse;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.AdvertisementAttribute;
import com.secondhand.backend.entity.AdvertisementImage;
import com.secondhand.backend.mapper.interfaces.AdminAdvertisementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAdvertisementMapperImpl
        implements AdminAdvertisementMapper {

    @Override
    public AdminAdvertisementSummaryResponse toSummaryResponse(
            Advertisement advertisement
    ) {

        if (advertisement == null) {
            return null;
        }

        return new AdminAdvertisementSummaryResponse(

                advertisement.getId(),

                advertisement.getTitle(),

                advertisement.getPrice(),

                advertisement.getStatus(),

                advertisement.getSeller().getUsername(),

                advertisement.getCategory().getName(),

                advertisement.getCity().getName(),

                advertisement.getCreatedAt()
        );

    }

    @Override
    public AdminAdvertisementDetailsResponse toDetailsResponse(
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

                advertisement.getBuyer() == null
                        ? null
                        : advertisement.getBuyer().getId(),

                advertisement.getBuyer() == null
                        ? null
                        : advertisement.getBuyer().getUsername(),

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

}
