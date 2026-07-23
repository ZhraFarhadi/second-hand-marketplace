package com.secondhand.frontend.config;

public final class ApiConfig {

    private ApiConfig() {
    }

    /*
     * Backend Base URL
     */

    public static final String BASE_URL =
            "http://localhost:8081/api";

    /*
     * Network Timeouts
     */

    public static final int CONNECT_TIMEOUT_SECONDS = 10;

    public static final int REQUEST_TIMEOUT_SECONDS = 15;

}