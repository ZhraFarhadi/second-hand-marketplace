
package com.secondhand.backend.validation.validator;

import com.secondhand.backend.validation.annotation.ValidPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhoneNumberValidator
        implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNumber,
                           ConstraintValidatorContext context) {

        if (phoneNumber == null) {
            return true;
        }

        return phoneNumber.matches("^09\\d{9}$");
    }
}