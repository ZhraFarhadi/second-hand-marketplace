package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminAdvertisementSummaryResponse;
import com.secondhand.backend.entity.Advertisement;

public interface AdminAdvertisementMapper {

    AdminAdvertisementSummaryResponse toSummaryResponse(
            Advertisement advertisement
    );

    AdminAdvertisementDetailsResponse toDetailsResponse(
            Advertisement advertisement
    );

}
