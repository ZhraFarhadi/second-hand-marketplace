package com.secondhand.backend.dto.auth.request;


import com.secondhand.backend.validation.annotation.PasswordMatches;
import com.secondhand.backend.validation.annotation.StrongPassword;
import com.secondhand.backend.validation.annotation.ValidPhoneNumber;
import com.secondhand.backend.validation.contract.PasswordConfirmation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class RegisterRequest implements PasswordConfirmation {

    @NotBlank(message = "Full name is required.")
    @Size(max = 100, message = "Full name must not exceed 100 characters.")
    private String fullName;



    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 30,
            message = "Username must be between 3 and 30 characters.")
    @Pattern(
            regexp = "^[a-zA-Z0-9._]+$",
            message = "Username can only contain letters, numbers, dots and underscores."
    )
    private String username;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email format is invalid.")
    @Size(max = 100, message = "Email must not exceed 100 characters.")
    private String email;

    @NotBlank(message = "Phone number is required.")
    @ValidPhoneNumber
    private String phoneNumber;

    @NotBlank(message = "Password is required.")
    @StrongPassword
    @Size(max = 64, message = "Password must not exceed 64 characters.")
    private String password;

    @NotBlank(message = "Confirm password is required.")
    private String confirmPassword;

}