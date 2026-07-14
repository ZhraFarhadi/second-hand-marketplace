package com.secondhand.backend.mapper.interfaces;


import com.secondhand.backend.dto.auth.request.RegisterRequest;
import com.secondhand.backend.dto.auth.response.LoginResponse;
import com.secondhand.backend.dto.auth.response.UserProfileResponse;
import com.secondhand.backend.dto.auth.response.UserSummaryResponse;
import com.secondhand.backend.entity.User;

public interface UserMapper {

    User toEntity(
            RegisterRequest request
    );

    LoginResponse toLoginResponse(
            User user,
            String token
    );

    UserSummaryResponse toSummaryResponse(
            User user
    );

    UserProfileResponse toProfileResponse(
            User user
    );

}
