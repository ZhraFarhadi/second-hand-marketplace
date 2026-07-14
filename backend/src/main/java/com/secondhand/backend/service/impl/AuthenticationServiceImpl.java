package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.auth.request.LoginRequest;
import com.secondhand.backend.dto.auth.request.RegisterRequest;
import com.secondhand.backend.dto.auth.response.LoginResponse;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.Role;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;

import com.secondhand.backend.mapper.interfaces.UserMapper;
import com.secondhand.backend.repository.UserRepository;
import com.secondhand.backend.security.JwtService;
import com.secondhand.backend.service.interfaces.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImpl
        implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request) {

        validateRegistrationData(request);

        User user = buildUser(request);

        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {

        User user =
                getUserByUsername(request.getUsername());

        validateLogin(
                user,
                request.getPassword()
        );

        String token =
                jwtService.generateToken(user);

        return userMapper.toLoginResponse(
                user,
                token
        );
    }

    private void validateRegistrationData(
            RegisterRequest request
    ) {

        if (userRepository.existsByUsername(
                request.getUsername())) {

            throw new BusinessException(
                    ErrorCode.USERNAME_ALREADY_EXISTS
            );
        }

        if (userRepository.existsByEmail(
                request.getEmail())) {

            throw new BusinessException(
                    ErrorCode.EMAIL_ALREADY_EXISTS
            );
        }

        if (userRepository.existsByPhoneNumber(
                request.getPhoneNumber())) {

            throw new BusinessException(
                    ErrorCode.PHONE_NUMBER_ALREADY_EXISTS
            );
        }

    }

    private User buildUser(
            RegisterRequest request
    ) {

        User user =
                userMapper.toEntity(request);

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole(Role.USER);

        user.setAccountStatus(
                AccountStatus.ACTIVE
        );

        return user;
    }

    private User getUserByUsername(
            String username
    ) {

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.INVALID_CREDENTIALS
                        )
                );
    }

    private void validateLogin(
            User user,
            String password
    ) {

        if (user.getAccountStatus()
                == AccountStatus.BLOCKED) {

            throw new BusinessException(
                    ErrorCode.USER_BLOCKED
            );
        }

        if (!passwordEncoder.matches(
                password,
                user.getPassword())) {

            throw new BusinessException(
                    ErrorCode.INVALID_CREDENTIALS
            );
        }

    }

}