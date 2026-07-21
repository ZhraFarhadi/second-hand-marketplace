package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.admin.response.AdminUserDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminUserSummaryResponse;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.mapper.interfaces.AdminUserMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminUserMapperImpl
        implements AdminUserMapper {

    @Override
    public AdminUserSummaryResponse toSummaryResponse(
            User user
    ) {

        if (user == null) {
            return null;
        }

        return new AdminUserSummaryResponse(
                user.getId(),
                user.getFullName(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getAccountStatus(),
                user.getAverageRating(),
                user.getRatingCount()
        );

    }

    @Override
    public AdminUserDetailsResponse toDetailsResponse(
            User user
    ) {

        if (user == null) {
            return null;
        }

        return new AdminUserDetailsResponse(
                user.getId(),
                user.getFullName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole(),
                user.getAccountStatus(),
                user.getAverageRating(),
                user.getRatingCount(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );

    }

}