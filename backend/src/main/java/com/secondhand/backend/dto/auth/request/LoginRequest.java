package com.secondhand.backend.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Username is required.")
    @Size(max = 30, message = "Username must not exceed 30 characters.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(max = 64, message = "Password must not exceed 64 characters.")
    private String password;

}
