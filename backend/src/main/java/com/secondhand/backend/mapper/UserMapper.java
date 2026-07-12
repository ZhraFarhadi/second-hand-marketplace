package com.secondhand.backend.mapper;

import com.secondhand.backend.dto.auth.request.RegisterRequest;
import com.secondhand.backend.dto.auth.response.LoginResponse;
import com.secondhand.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(RegisterRequest request) {

        User user = new User();

        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());

        return user;
    }

    public LoginResponse toLoginResponse(User user, String token) {

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                token
        );
    }

}