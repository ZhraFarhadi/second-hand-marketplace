package com.secondhand.frontend.util;

import java.util.regex.Pattern;

public final class ValidationUtil {

    private ValidationUtil() {
    }

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^09\\d{9}$");

    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._]+$");

    private static final Pattern UPPERCASE_PATTERN =
            Pattern.compile(".*[A-Z].*");

    private static final Pattern LOWERCASE_PATTERN =
            Pattern.compile(".*[a-z].*");

    private static final Pattern DIGIT_PATTERN =
            Pattern.compile(".*\\d.*");

    private static final Pattern SPECIAL_PATTERN =
            Pattern.compile(".*[@#$%^&+=!].*");

    public static boolean isValidEmail(String email) {

        return EMAIL_PATTERN.matcher(email).matches();

    }

    public static boolean isValidPhone(String phone) {

        return PHONE_PATTERN.matcher(phone).matches();

    }

    public static boolean isValidUsername(String username) {

        return USERNAME_PATTERN.matcher(username).matches();

    }

    public static boolean hasUppercase(String password) {

        return UPPERCASE_PATTERN.matcher(password).matches();

    }

    public static boolean hasLowercase(String password) {

        return LOWERCASE_PATTERN.matcher(password).matches();

    }

    public static boolean hasDigit(String password) {

        return DIGIT_PATTERN.matcher(password).matches();

    }

    public static boolean hasSpecialCharacter(String password) {

        return SPECIAL_PATTERN.matcher(password).matches();

    }

    public static boolean hasValidPasswordLength(String password) {

        return password.length() >= 8 && password.length() <= 64;

    }

}