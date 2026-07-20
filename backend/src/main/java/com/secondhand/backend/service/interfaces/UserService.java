package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.auth.request.ChangePasswordRequest;
import com.secondhand.backend.dto.auth.request.UpdateProfileRequest;
import com.secondhand.backend.dto.auth.response.UserProfileResponse;
import com.secondhand.backend.dto.rating.response.SellerProfileResponse;

public interface UserService {

    UserProfileResponse getMyProfile();

    UserProfileResponse updateProfile(
            UpdateProfileRequest request
    );

    void changePassword(
            ChangePasswordRequest request
    );

    SellerProfileResponse getSellerProfile(
            Long sellerId
    );
}
