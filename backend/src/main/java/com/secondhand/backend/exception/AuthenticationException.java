package com.secondhand.backend.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends BusinessException {

    public AuthenticationException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }

}