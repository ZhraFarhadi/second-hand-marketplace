package com.secondhand.backend.exception.auth;

import com.secondhand.backend.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistsException extends BusinessException {

    public UsernameAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Username already exists.");
    }

}