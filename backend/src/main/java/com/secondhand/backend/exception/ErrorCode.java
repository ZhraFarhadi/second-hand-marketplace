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

    CATEGORY_ALREADY_EXISTS(
            HttpStatus.CONFLICT,
            "Category already exists."
    ),

    CATEGORY_HAS_CHILDREN(
            HttpStatus.BAD_REQUEST,
            "Category cannot be deleted because it has child categories."
    ),

    CATEGORY_HAS_ADVERTISEMENTS(
            HttpStatus.BAD_REQUEST,
            "Category cannot be deleted because it is used by advertisements."
    ),

    INVALID_CATEGORY_HIERARCHY(
            HttpStatus.BAD_REQUEST,
            "Invalid category hierarchy."
    ),

    CATEGORY_NAME_ALREADY_EXISTS(
            HttpStatus.CONFLICT,
            "Category name already exists."
    ),

    CATEGORY_ATTRIBUTE_ALREADY_EXISTS(
            HttpStatus.CONFLICT,
            "Category attribute already exists."
    ),

    CATEGORY_ATTRIBUTE_IN_USE(
            HttpStatus.BAD_REQUEST,
            "Category attribute is used by advertisements."
    ),

    INVALID_ATTRIBUTE_DATA_TYPE(
            HttpStatus.BAD_REQUEST,
            "Invalid attribute data type."
    ),

    CATEGORY_IS_NOT_LEAF(
            HttpStatus.BAD_REQUEST,
            "Operation is only allowed on leaf categories."
    ),

    CATEGORY_HAS_ATTRIBUTES(
            HttpStatus.BAD_REQUEST,
            "Category cannot have child categories because it already has attributes."
    ),

    INVALID_CATEGORY_ATTRIBUTE_NAME(
            HttpStatus.BAD_REQUEST,
            "Category attribute name is invalid."
    ),

    ATTRIBUTE_OPTION_REQUIRED(
            HttpStatus.BAD_REQUEST,
            "An option must be selected for this attribute."
    ),

    SELECT_ATTRIBUTE_OPTIONS_REQUIRED(
            HttpStatus.BAD_REQUEST,
            "Select attribute must contain at least one option."
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

    PROVINCE_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Province not found."
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

    CANNOT_MESSAGE_YOURSELF(
            HttpStatus.BAD_REQUEST,
            "You cannot start a conversation with yourself."
    ),

    ADVERTISEMENT_NOT_AVAILABLE_FOR_CONVERSATION(
            HttpStatus.BAD_REQUEST,
            "Conversation can only be started for active advertisements."
    ),

    CONVERSATION_ACCESS_DENIED(
            HttpStatus.FORBIDDEN,
            "You do not have access to this conversation."
    ),

    CANNOT_START_CONVERSATION_WITH_SELF(
            HttpStatus.BAD_REQUEST,
            "You cannot start a conversation with yourself."
    ),

    INVALID_MESSAGE_CONTENT(
            HttpStatus.BAD_REQUEST,
            "Message content cannot be empty."
    ),

    /*
     * ==========================
     * Favorite
     * ==========================
     */

    CANNOT_FAVORITE_OWN_ADVERTISEMENT(
            HttpStatus.FORBIDDEN,
            "You cannot favorite your own advertisement."
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

    BUYER_CANNOT_BE_SELLER(
            HttpStatus.BAD_REQUEST,
            "Buyer cannot be the seller of the advertisement."
    ),

    BUYER_ACCOUNT_NOT_ACTIVE(
            HttpStatus.BAD_REQUEST,
            "Buyer account is not active."
    ),

    INVALID_BUYER(
            HttpStatus.BAD_REQUEST,
            "Buyer must have a conversation for this advertisement."
    ),

    SELLER_ACCOUNT_NOT_ACTIVE(
            HttpStatus.BAD_REQUEST,
            "Seller is not active."
    ),

    RATING_ALREADY_EXISTS(
            HttpStatus.CONFLICT,
            "You have already rated this seller for this advertisement."
    ),

    CANNOT_RATE_YOURSELF(
            HttpStatus.BAD_REQUEST,
            "You cannot rate yourself."
    ),

    ADVERTISEMENT_NOT_PURCHASED(
            HttpStatus.BAD_REQUEST,
            "Only the buyer of this advertisement can rate the seller."
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

    ADVERTISEMENT_NOT_PENDING(
            HttpStatus.BAD_REQUEST,
            "Advertisement is not pending review."
    ),

    ADMIN_REVIEW_COMMENT_REQUIRED(
            HttpStatus.BAD_REQUEST,
            "Review comment is required."
    ),

    USER_ALREADY_BLOCKED(
            HttpStatus.BAD_REQUEST,
            "User is already blocked."
    ),

    USER_ALREADY_ACTIVE(
            HttpStatus.BAD_REQUEST,
            "User is already active."
    ),

    CANNOT_BLOCK_ADMIN(
            HttpStatus.BAD_REQUEST,
            "Administrator accounts cannot be blocked."
    ),

    CANNOT_BLOCK_YOURSELF(
            HttpStatus.BAD_REQUEST,
            "You cannot block your own account."
    ),


    ADMIN_CANNOT_BLOCK_SELF(
            HttpStatus.BAD_REQUEST,
            "You cannot change your own account status."
    ),

    ADMIN_STATUS_CHANGE_NOT_ALLOWED(
            HttpStatus.BAD_REQUEST,
            "Another administrator cannot be blocked or activated."
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