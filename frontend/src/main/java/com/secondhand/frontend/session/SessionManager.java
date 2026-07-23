package com.secondhand.frontend.session;

import com.secondhand.frontend.model.Role;

public class SessionManager {

    private static boolean loggedIn = false;

    private static Long userId;

    private static String username;

    private static Role role;

    private static String token;



    public static void login(
            Long id,
            String user,
            Role userRole,
            String jwtToken
    ) {

        loggedIn = true;

        userId = id;

        username = user;

        role = userRole;

        token = jwtToken;

    }

    public static void logout() {

        loggedIn = false;

        userId = null;

        username = null;

        role = null;

        token = null;

    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static Long getUserId() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

    public static Role getRole() {
        return role;
    }

    public static String getToken() {
        return token;
    }

    public static void setUserId(Long userId) {
        SessionManager.userId = userId;
    }

    public static void setRole(Role role) {
        SessionManager.role = role;
    }
}