package com.secondhand.backend.validation.annotation;

import com.secondhand.backend.validation.validator.StrongPasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {StrongPasswordValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {

    String message() default "Password is not strong enough.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}