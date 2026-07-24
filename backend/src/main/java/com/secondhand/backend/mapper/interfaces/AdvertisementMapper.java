package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.advertisement.response.AdvertisementDetailsResponse;
import com.secondhand.backend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.backend.dto.advertisement.response.MyAdvertisementSummaryResponse;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;

public interface AdvertisementMapper {

    AdvertisementDetailsResponse toDetailsResponse(
            Advertisement advertisement
    );

    AdvertisementSummaryResponse toSummaryResponse(
            Advertisement advertisement
    );

    MyAdvertisementSummaryResponse toMySummaryResponse(
            Advertisement advertisement
    );

    AdvertisementSummaryResponse toSummaryResponse(
            Advertisement advertisement,
            boolean isFavorite,
            boolean isOwner
    );

    AdvertisementDetailsResponse toDetailsResponse(
            Advertisement advertisement,
            boolean isFavorite,
            boolean isOwner
    );
    AdminAdvertisementDetailsResponse toAdminDetailsResponse(
            Advertisement advertisement
    );



}
