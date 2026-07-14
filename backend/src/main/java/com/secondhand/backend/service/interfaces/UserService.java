package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.auth.request.ChangePasswordRequest;
import com.secondhand.backend.dto.auth.request.UpdateProfileRequest;
import com.secondhand.backend.dto.auth.response.UserProfileResponse;

public interface UserService {

    UserProfileResponse getProfile();

    UserProfileResponse updateProfile(
            UpdateProfileRequest request
    );

    void changePassword(
            ChangePasswordRequest request
    );

}
