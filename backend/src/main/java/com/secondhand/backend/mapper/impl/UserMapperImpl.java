package com.secondhand.backend.mapper.impl;
import com.secondhand.backend.dto.auth.request.RegisterRequest;
import com.secondhand.backend.dto.auth.response.LoginResponse;
import com.secondhand.backend.dto.auth.response.UserProfileResponse;
import com.secondhand.backend.dto.auth.response.UserSummaryResponse;
import com.secondhand.backend.dto.rating.response.SellerProfileResponse;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.mapper.interfaces.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl
        implements UserMapper {

    @Override
    public User toEntity(
            RegisterRequest request
    ) {

        if (request == null) {
            return null;
        }

        User user = new User();

        user.setFullName(
                request.getFullName().trim()
        );

        user.setUsername(
                request.getUsername().trim()
        );

        user.setEmail(
                request.getEmail().trim()
        );

        user.setPhoneNumber(
                request.getPhoneNumber().trim()
        );

        return user;
    }

    @Override
    public LoginResponse toLoginResponse(
            User user,
            String token
    ) {

        if (user == null) {
            return null;
        }

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                token
        );

    }

    @Override
    public UserSummaryResponse toSummaryResponse(
            User user
    ) {

        if (user == null) {
            return null;
        }

        return new UserSummaryResponse(
                user.getId(),
                user.getFullName(),
                user.getUsername()
        );

    }

    @Override
    public UserProfileResponse toProfileResponse(
            User user
    ) {

        return new UserProfileResponse(
                user.getId(),
                user.getFullName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole(),
                user.getAccountStatus()

        );

    }

    @Override
    public SellerProfileResponse toSellerProfileResponse(
            User user
    ) {

        if (user == null) {
            return null;
        }

        return new SellerProfileResponse(
                user.getId(),
                user.getFullName(),
                user.getUsername(),
                user.getAverageRating(),
                user.getRatingCount()
        );

    }

}