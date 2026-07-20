package com.secondhand.frontend.exception;

public class ApiException extends Exception {

    private final int status;
    private final String errorCode;

    public ApiException(int status, String errorCode, String message) {

        super(message);

        this.status = status;
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }
}