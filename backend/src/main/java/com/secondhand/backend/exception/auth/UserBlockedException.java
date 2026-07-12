package com.secondhand.backend.exception.auth;

import com.secondhand.backend.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserBlockedException extends BusinessException {

    public UserBlockedException() {
        super(HttpStatus.FORBIDDEN, "Your account has been blocked.");
    }

}