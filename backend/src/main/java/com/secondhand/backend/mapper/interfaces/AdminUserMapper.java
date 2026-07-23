package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.admin.response.AdminUserDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminUserSummaryResponse;
import com.secondhand.backend.entity.User;

public interface AdminUserMapper {

    AdminUserSummaryResponse toSummaryResponse(
            User user
    );

    AdminUserDetailsResponse toDetailsResponse(
            User user
    );

}