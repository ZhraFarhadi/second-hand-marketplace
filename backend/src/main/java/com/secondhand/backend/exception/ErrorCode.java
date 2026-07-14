package com.secondhand.backend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    /*
     * ==========================
     * Authentication
     * ==========================
     */

    INVALID_CREDENTIALS(
            HttpStatus.UNAUTHORIZED,
            "Invalid username or password."
    ),

    INVALID_TOKEN(
            HttpStatus.UNAUTHORIZED,
            "Invalid or expired token."
    ),

    USER_BLOCKED(
            HttpStatus.FORBIDDEN,
            "Your account has been blocked."
    ),

    UNAUTHORIZED(
            HttpStatus.UNAUTHORIZED,
            "Authentication is required."
    ),

    ACCESS_DENIED(
            HttpStatus.FORBIDDEN,
            "You do not have permission to perform this action."
    ),

    /*
     * ==========================
     * Registration
     * ==========================
     */

    USERNAME_ALREADY_EXISTS(
            HttpStatus.CONFLICT,
            "Username already exists."
    ),

    EMAIL_ALREADY_EXISTS(
            HttpStatus.CONFLICT,
            "Email already exists."
    ),

    PHONE_NUMBER_ALREADY_EXISTS(
            HttpStatus.CONFLICT,
            "Phone number already exists."
    ),

    /*
     * ==========================
     * Advertisement
     * ==========================
     */

    ADVERTISEMENT_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Advertisement not found."
    ),

    ADVERTISEMENT_NOT_ACTIVE(
            HttpStatus.BAD_REQUEST,
            "Advertisement is not active."
    ),

    ADVERTISEMENT_ALREADY_SOLD(
            HttpStatus.BAD_REQUEST,
            "Sold advertisements cannot be modified."
    ),

    INVALID_PRIMARY_IMAGE(
            HttpStatus.BAD_REQUEST,
            "Exactly one primary image is required."
    ),

    INVALID_ATTRIBUTE(
            HttpStatus.BAD_REQUEST,
            "Invalid advertisement attribute."
    ),

    DUPLICATE_ATTRIBUTE(
            HttpStatus.BAD_REQUEST,
            "Duplicate advertisement attribute."
    ),

    ADVERTISEMENT_NOT_OWNER(
            HttpStatus.FORBIDDEN,
            "You are not allowed to modify this advertisement."
    ),

    ADVERTISEMENT_CANNOT_BE_DELETED(
            HttpStatus.BAD_REQUEST,
            "Sold advertisements cannot be deleted."
    ),

    ADVERTISEMENT_CANNOT_BE_UPDATED(
            HttpStatus.BAD_REQUEST,
            "Sold advertisements cannot be updated."
    ),

    INVALID_ATTRIBUTE_VALUE(
            HttpStatus.BAD_REQUEST,
            "Invalid attribute value."
    ),


    /*
     * ==========================
     * User
     * ==========================
     */

    USER_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "User not found."
    ),

    /*
     * ==========================
     * Category
     * ==========================
     */

    CATEGORY_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Category not found."
    ),

    CATEGORY_ATTRIBUTE_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Category attribute not found."
    ),

    /*
     * ==========================
     * City
     * ==========================
     */

    CITY_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "City not found."
    ),

    /*
     * ==========================
     * Conversation
     * ==========================
     */

    CONVERSATION_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Conversation not found."
    ),

    MESSAGE_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Message not found."
    ),

    /*
     * ==========================
     * Favorite
     * ==========================
     */

    FAVORITE_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Favorite not found."
    ),

    /*
     * ==========================
     * Rating
     * ==========================
     */

    RATING_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Rating not found."
    ),

    /*
     * ==========================
     * Admin
     * ==========================
     */

    REVIEW_ALREADY_COMPLETED(
            HttpStatus.BAD_REQUEST,
            "Review has already been completed."
    ),

    ADVERTISEMENT_ALREADY_REVIEWED(
            HttpStatus.BAD_REQUEST,
            "Advertisement has already been reviewed."
    ),

    /*
     * ==========================
     * Common
     * ==========================
     */

    RESOURCE_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Resource not found."
    ),

    VALIDATION_ERROR(
            HttpStatus.BAD_REQUEST,
            "Validation failed."
    ),

    INTERNAL_SERVER_ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "An unexpected error occurred."
    );

    private final HttpStatus status;

    private final String defaultMessage;

    ErrorCode(
            HttpStatus status,
            String defaultMessage
    ) {
        this.status = status;
        this.defaultMessage = defaultMessage;
    }

}