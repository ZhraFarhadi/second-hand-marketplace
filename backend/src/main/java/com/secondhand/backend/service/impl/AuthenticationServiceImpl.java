package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.auth.request.LoginRequest;
import com.secondhand.backend.dto.auth.request.RegisterRequest;
import com.secondhand.backend.dto.auth.response.LoginResponse;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.Role;
import com.secondhand.backend.exception.AuthenticationException;
import com.secondhand.backend.exception.DuplicateResourceException;
import com.secondhand.backend.mapper.UserMapper;
import com.secondhand.backend.repository.UserRepository;
import com.secondhand.backend.security.JwtService;
import com.secondhand.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request) {

        validateUniqueFields(request);

        User user = userMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setAccountStatus(AccountStatus.ACTIVE);

        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new AuthenticationException("Invalid username or password."));

        if (user.getAccountStatus() == AccountStatus.BLOCKED) {
            throw new AuthenticationException("Your account has been blocked.");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Invalid username or password.");
        }

        String token = jwtService.generateToken(user);

        return userMapper.toLoginResponse(user, token);
    }

    private void validateUniqueFields(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateResourceException("Username already exists.");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists.");
        }

        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new DuplicateResourceException("Phone number already exists.");
        }
    }

}