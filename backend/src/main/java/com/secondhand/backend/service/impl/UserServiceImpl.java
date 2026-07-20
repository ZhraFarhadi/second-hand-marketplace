package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.auth.request.ChangePasswordRequest;
import com.secondhand.backend.dto.auth.request.UpdateProfileRequest;
import com.secondhand.backend.dto.auth.response.UserProfileResponse;
import com.secondhand.backend.dto.rating.response.SellerProfileResponse;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.UserMapper;
import com.secondhand.backend.repository.UserRepository;
import com.secondhand.backend.service.interfaces.CurrentUserService;
import com.secondhand.backend.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUserService currentUserService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserProfileResponse getMyProfile() {

        User user = currentUserService.getCurrentUser();

        return userMapper.toProfileResponse(user);
    }

    @Override
    public UserProfileResponse updateProfile(
            UpdateProfileRequest request
    ) {

        User user = currentUserService.getCurrentUser();

        validateProfileChanges(
                user,
                request
        );

        updateUserProfile(
                user,
                request
        );

        User updatedUser =
                userRepository.save(user);

        return userMapper.toProfileResponse(
                updatedUser
        );
    }

    @Override
    public void changePassword(
            ChangePasswordRequest request
    ) {

        User user = currentUserService.getCurrentUser();

        validateCurrentPassword(
                user,
                request.getCurrentPassword()
        );

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public SellerProfileResponse getSellerProfile(
            Long sellerId
    ) {

        User seller = userRepository.findById(sellerId)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.USER_NOT_FOUND
                        )
                );

        validateSellerIsActive(seller);

        return userMapper.toSellerProfileResponse(
                seller
        );

    }

    private void validateProfileChanges(
            User user,
            UpdateProfileRequest request
    ) {

        if (!user.getEmail().equals(request.getEmail())
                && userRepository.existsByEmail(request.getEmail())) {

            throw new BusinessException(
                    ErrorCode.EMAIL_ALREADY_EXISTS
            );
        }

        if (!user.getPhoneNumber().equals(request.getPhoneNumber())
                && userRepository.existsByPhoneNumber(request.getPhoneNumber())) {

            throw new BusinessException(
                    ErrorCode.PHONE_NUMBER_ALREADY_EXISTS
            );
        }

    }

    private void updateUserProfile(
            User user,
            UpdateProfileRequest request
    ) {

        user.setFullName(
                request.getFullName().trim()
        );

        user.setEmail(
                request.getEmail().trim()
        );

        user.setPhoneNumber(
                request.getPhoneNumber().trim()
        );

    }

    private void validateCurrentPassword(
            User user,
            String currentPassword
    ) {

        if (!passwordEncoder.matches(
                currentPassword,
                user.getPassword()
        )) {

            throw new BusinessException(
                    ErrorCode.INVALID_CREDENTIALS
            );
        }

    }

    private void validateSellerIsActive(
            User seller
    ) {

        if (seller.getAccountStatus() != AccountStatus.ACTIVE) {

            throw new BusinessException(
                    ErrorCode.SELLER_ACCOUNT_NOT_ACTIVE
            );

        }

    }



}