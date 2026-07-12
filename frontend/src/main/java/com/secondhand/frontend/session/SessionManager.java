package com.secondhand.frontend.session;

public class SessionManager {

    private static boolean loggedIn = false;

    public static void login() {

        loggedIn = true;

    }

    public static void logout() {

        loggedIn = false;

    }

    public static boolean isLoggedIn() {

        return loggedIn;

    }

}