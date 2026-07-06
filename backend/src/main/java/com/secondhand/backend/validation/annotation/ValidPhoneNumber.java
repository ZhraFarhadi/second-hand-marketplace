
package com.secondhand.backend.validation.annotation;

import com.secondhand.backend.validation.validator.ValidPhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidPhoneNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {

    String message() default "Phone number is invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}