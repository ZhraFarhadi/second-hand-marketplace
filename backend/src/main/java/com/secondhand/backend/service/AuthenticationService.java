package com.secondhand.backend.service;

import com.secondhand.backend.dto.auth.request.LoginRequest;
import com.secondhand.backend.dto.auth.request.RegisterRequest;
import com.secondhand.backend.dto.auth.response.LoginResponse;

public interface AuthenticationService {

    void register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}