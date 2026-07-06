package com.secondhand.backend.validation.validator;

import com.secondhand.backend.validation.annotation.StrongPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator
        implements ConstraintValidator<StrongPassword, String> {

    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext context) {

        if (password == null) {
            return true;
        }

        return password.matches(
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&._-])[A-Za-z\\d@$!%*?&._-]{8,255}$"
        );
    }
}
