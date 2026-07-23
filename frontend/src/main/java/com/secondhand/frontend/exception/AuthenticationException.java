package com.secondhand.frontend.exception;

public class AuthenticationException extends ApiException {

    public AuthenticationException(
            int status,
            String errorCode,
            String message
    ) {
        super(status, errorCode, message);
    }
}