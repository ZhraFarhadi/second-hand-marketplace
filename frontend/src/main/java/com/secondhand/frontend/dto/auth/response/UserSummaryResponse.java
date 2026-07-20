package com.secondhand.frontend.dto.auth.response;

public class UserSummaryResponse {

    private Long id;
    private String fullName;
    private String username;

    public UserSummaryResponse() {
    }

    public UserSummaryResponse(
            Long id,
            String fullName,
            String username
    ) {

        this.id = id;
        this.fullName = fullName;
        this.username = username;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}