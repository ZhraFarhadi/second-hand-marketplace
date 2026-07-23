package com.secondhand.backend.dto.auth.request;

import com.secondhand.backend.validation.annotation.PasswordMatches;
import com.secondhand.backend.validation.annotation.StrongPassword;
import com.secondhand.backend.validation.contract.PasswordConfirmation;
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
@PasswordMatches
public class ChangePasswordRequest implements PasswordConfirmation {

    @NotBlank(message = "Current password is required.")
    @Size(max = 64, message = "Current password must not exceed 64 characters.")
    private String currentPassword;

    @NotBlank(message = "New password is required.")
    @StrongPassword
    @Size(max = 64, message = "New password must not exceed 64 characters.")
    private String password;

    @NotBlank(message = "Confirm password is required.")
    private String confirmPassword;

}