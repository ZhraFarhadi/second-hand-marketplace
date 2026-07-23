package com.secondhand.frontend.exception;

import com.secondhand.frontend.dto.common.ErrorResponse;

public class ExceptionHandler {

    private ExceptionHandler() {
    }

    public static ApiException fromError(ErrorResponse error) {

        String code = error.getErrorCode();

        if (code == null) {

            return new ApiException(
                    error.getStatus(),
                    null,
                    error.getMessage()
            );
        }

        return switch (code) {

            case "INVALID_CREDENTIALS",
                 "INVALID_TOKEN",
                 "USER_BLOCKED",
                 "UNAUTHORIZED",
                 "ACCESS_DENIED"

                    -> new AuthenticationException(
                    error.getStatus(),
                    code,
                    error.getMessage()
            );

            case "VALIDATION_ERROR"

                    -> new ValidationException(
                    error.getStatus(),
                    code,
                    error.getMessage()
            );

            default

                    -> new ApiException(
                    error.getStatus(),
                    code,
                    error.getMessage()
            );
        };
    }
}