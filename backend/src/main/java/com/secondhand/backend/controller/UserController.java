package com.secondhand.backend.controller;



import com.secondhand.backend.dto.auth.request.ChangePasswordRequest;
import com.secondhand.backend.dto.auth.request.UpdateProfileRequest;
import com.secondhand.backend.dto.auth.response.UserProfileResponse;
import com.secondhand.backend.dto.rating.response.SellerProfileResponse;
import com.secondhand.backend.service.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserProfileResponse getProfile() {

        return userService.getMyProfile();
    }

    @PutMapping("/me")
    public UserProfileResponse updateProfile(

            @Valid
            @RequestBody
            UpdateProfileRequest request
    ) {

        return userService.updateProfile(request);
    }

    @PatchMapping("/me/password")
    public void changePassword(

            @Valid
            @RequestBody
            ChangePasswordRequest request
    ) {

        userService.changePassword(request);
    }

    @GetMapping("/{sellerId}/profile")
    public SellerProfileResponse getSellerProfile(
            @PathVariable Long sellerId
    ) {

        return userService.getSellerProfile(
                sellerId
        );

    }

}