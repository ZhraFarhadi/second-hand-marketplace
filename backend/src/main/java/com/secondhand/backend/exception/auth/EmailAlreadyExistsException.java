package com.secondhand.backend.exception.auth;

import com.secondhand.backend.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends BusinessException {

    public EmailAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Email already exists.");
    }

}