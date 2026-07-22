package com.secondhand.frontend.dto.profile.request;

public class UpdateProfileRequest {

    private String fullName;
    private String email;
    private String phoneNumber;

    public UpdateProfileRequest() {
    }

    public UpdateProfileRequest(
            String fullName,
            String email,
            String phoneNumber
    ) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}