package com.secondhand.frontend.dto.auth.response;

public class LoginResponse {

    private Long userId;
    private String username;
    private String role;
    private String token;

    public LoginResponse() {
    }

    public LoginResponse(
            Long userId,
            String username,
            String role,
            String token
    ) {

        this.userId = userId;
        this.username = username;
        this.role = role;
        this.token = token;

    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }

}