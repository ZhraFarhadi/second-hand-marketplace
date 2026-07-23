package com.secondhand.frontend.repository;

import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.profile.request.ChangePasswordRequest;
import com.secondhand.frontend.dto.profile.request.UpdateProfileRequest;
import com.secondhand.frontend.dto.profile.response.UserProfileResponse;

public class ProfileRepository {


    private static final String BASE_ENDPOINT = "/users/me";

    public UserProfileResponse getProfile() throws Exception {

        return ApiClient.get(
                BASE_ENDPOINT,
                new TypeToken<UserProfileResponse>() {}.getType()
        );

    }

    public UserProfileResponse updateProfile(
            UpdateProfileRequest request
    ) throws Exception {

        return ApiClient.put(
                BASE_ENDPOINT,
                request,
                new TypeToken<UserProfileResponse>() {}.getType()
        );

    }

    public void changePassword(
            ChangePasswordRequest request
    ) throws Exception {

        ApiClient.patch(
                BASE_ENDPOINT + "/password",
                request
        );

    }

}