package com.secondhand.backend.exception.auth;

import com.secondhand.backend.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class PhoneNumberAlreadyExistsException extends BusinessException {

    public PhoneNumberAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Phone number already exists.");
    }

}