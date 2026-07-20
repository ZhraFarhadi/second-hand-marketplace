package com.secondhand.frontend.service;

import com.google.gson.Gson;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.auth.request.LoginRequest;
import com.secondhand.frontend.dto.auth.request.RegisterRequest;
import com.secondhand.frontend.dto.auth.response.LoginResponse;
import com.secondhand.frontend.util.JsonUtil;

public final class AuthenticationService {

    private static final AuthenticationService INSTANCE =
            new AuthenticationService();

    private static final Gson GSON =
            JsonUtil.getGson();

    private AuthenticationService() {
    }

    public static AuthenticationService getInstance() {
        return INSTANCE;
    }

    public LoginResponse login(LoginRequest request) throws Exception {

        String response =
                ApiClient.post("/auth/login", request);

        return GSON.fromJson(response, LoginResponse.class);

    }

    public void register(RegisterRequest request) throws Exception {

        ApiClient.post("/auth/register", request);

    }

}