package com.secondhand.frontend.exception;

public class ValidationException extends ApiException {

    public ValidationException(
            int status,
            String errorCode,
            String message
    ) {
        super(status, errorCode, message);
    }
}