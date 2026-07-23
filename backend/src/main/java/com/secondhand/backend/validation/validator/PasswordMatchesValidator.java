package com.secondhand.backend.validation.validator;

import com.secondhand.backend.validation.contract.PasswordConfirmation;
import com.secondhand.backend.validation.annotation.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, PasswordConfirmation> {

    @Override
    public boolean isValid(PasswordConfirmation value,
                           ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return Objects.equals(
                value.getPassword(),
                value.getConfirmPassword()
        );
    }
}