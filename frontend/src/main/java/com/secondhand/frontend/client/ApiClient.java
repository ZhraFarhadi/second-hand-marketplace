package com.secondhand.frontend.client;

import com.google.gson.Gson;
import com.secondhand.frontend.config.ApiConfig;
import com.secondhand.frontend.dto.common.ErrorResponse;
import com.secondhand.frontend.exception.ApiException;
import com.secondhand.frontend.session.SessionManager;
import com.secondhand.frontend.util.JsonUtil;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.lang.reflect.Type;

public final class ApiClient {

    private static final HttpClient client =
            HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(
                            ApiConfig.CONNECT_TIMEOUT_SECONDS
                    ))
                    .build();

    private static final Gson gson =
            JsonUtil.getGson();

    private ApiClient() {
    }

    public static String post(String endpoint, Object body)
            throws IOException,
            InterruptedException,
            ApiException {

        String json =
                gson.toJson(body);

        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        ApiConfig.BASE_URL + endpoint
                                )
                        )
                        .timeout(Duration.ofSeconds(
                                ApiConfig.REQUEST_TIMEOUT_SECONDS
                        ))
                        .header(
                                "Content-Type",
                                "application/json"
                        );

        /*
         * JWT
         */

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );

        }

        HttpRequest request =
                builder.POST(
                        HttpRequest.BodyPublishers.ofString(json)
                ).build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        /*
         * Success
         */

        if (response.statusCode() >= 200
                && response.statusCode() < 300) {

            return response.body();

        }

        /*
         * Error
         */

        ErrorResponse error =
                gson.fromJson(
                        response.body(),
                        ErrorResponse.class
                );

        throw new ApiException(

                response.statusCode(),

                error.getErrorCode(),

                error.getMessage()

        );

    }

    public static <T> T post(
            String endpoint,
            Object body,
            Type responseType
    )
            throws IOException,
            InterruptedException,
            ApiException {

        String json = gson.toJson(body);

        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        ApiConfig.BASE_URL + endpoint
                                )
                        )
                        .timeout(
                                Duration.ofSeconds(
                                        ApiConfig.REQUEST_TIMEOUT_SECONDS
                                )
                        )
                        .header(
                                "Content-Type",
                                "application/json"
                        );

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );

        }

        HttpRequest request =
                builder.POST(
                        HttpRequest.BodyPublishers.ofString(json)
                ).build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() >= 200 &&
                response.statusCode() < 300) {

            return gson.fromJson(
                    response.body(),
                    responseType
            );

        }

        ErrorResponse error =
                gson.fromJson(
                        response.body(),
                        ErrorResponse.class
                );

        throw new ApiException(
                response.statusCode(),
                error.getErrorCode(),
                error.getMessage()
        );

    }

    public static String get(String endpoint)

            throws IOException,
            InterruptedException,
            ApiException {

        System.out.println("STEP 9 ApiClient GET");


        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        ApiConfig.BASE_URL + endpoint
                                )
                        )
                        .timeout(
                                Duration.ofSeconds(
                                        ApiConfig.REQUEST_TIMEOUT_SECONDS
                                )
                        );

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );
        }

        HttpRequest request =
                builder.GET().build();

        System.out.println("TOKEN = " + SessionManager.getToken());
        System.out.println("LOGGED = " + SessionManager.isLoggedIn());

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );



        if (response.statusCode() >= 200
                && response.statusCode() < 300) {

            return response.body();

        }


        System.out.println("STATUS = " + response.statusCode());
        System.out.println("BODY = " + response.body());
        ErrorResponse error =
                gson.fromJson(response.body(), ErrorResponse.class);

        if (error == null) {

            throw new ApiException(
                    response.statusCode(),
                    "UNKNOWN_ERROR",
                    "HTTP " + response.statusCode()
            );

        }

        throw new ApiException(
                response.statusCode(),
                error.getErrorCode(),
                error.getMessage()
        );

    }



    public static void delete(String endpoint)
            throws IOException,
            InterruptedException,
            ApiException {

        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        ApiConfig.BASE_URL + endpoint
                                )
                        )
                        .timeout(
                                Duration.ofSeconds(
                                        ApiConfig.REQUEST_TIMEOUT_SECONDS
                                )
                        );

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );
        }

        HttpResponse<String> response =
                client.send(
                        builder.DELETE().build(),
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() >= 200
                && response.statusCode() < 300) {

            return;

        }

        ErrorResponse error =
                gson.fromJson(
                        response.body(),
                        ErrorResponse.class
                );

        throw new ApiException(

                response.statusCode(),

                error.getErrorCode(),

                error.getMessage()

        );

    }

    public static String put(String endpoint, Object body)
            throws IOException,
            InterruptedException,
            ApiException {

        String json =
                gson.toJson(body);

        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        ApiConfig.BASE_URL + endpoint
                                )
                        )
                        .timeout(
                                Duration.ofSeconds(
                                        ApiConfig.REQUEST_TIMEOUT_SECONDS
                                )
                        )
                        .header(
                                "Content-Type",
                                "application/json"
                        );

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );
        }

        HttpResponse<String> response =
                client.send(
                        builder.PUT(
                                HttpRequest.BodyPublishers.ofString(json)
                        ).build(),
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() >= 200
                && response.statusCode() < 300) {

            return response.body();

        }

        System.out.println("STATUS = " + response.statusCode());
        System.out.println("BODY = " + response.body());

        ErrorResponse error =
                gson.fromJson(
                        response.body(),
                        ErrorResponse.class
                );

        throw new ApiException(

                response.statusCode(),

                error.getErrorCode(),

                error.getMessage()

        );

    }

    public static String patch(String endpoint)
            throws IOException,
            InterruptedException,
            ApiException {

        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        ApiConfig.BASE_URL + endpoint
                                )
                        )
                        .timeout(
                                Duration.ofSeconds(
                                        ApiConfig.REQUEST_TIMEOUT_SECONDS
                                )
                        );

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );
        }

        HttpRequest request =
                builder.method(
                        "PATCH",
                        HttpRequest.BodyPublishers.noBody()
                ).build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() >= 200
                && response.statusCode() < 300) {

            return response.body();

        }

        ErrorResponse error =
                gson.fromJson(
                        response.body(),
                        ErrorResponse.class
                );

        throw new ApiException(

                response.statusCode(),

                error.getErrorCode(),

                error.getMessage()

        );

    }


    public static <T> T get(
            String endpoint,
            Type responseType
    )
            throws IOException,
            InterruptedException,
            ApiException {

        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        ApiConfig.BASE_URL + endpoint
                                )
                        )
                        .timeout(
                                Duration.ofSeconds(
                                        ApiConfig.REQUEST_TIMEOUT_SECONDS
                                )
                        );

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );

        }

        HttpRequest request =
                builder.GET().build();

        System.out.println("TOKEN = " + SessionManager.getToken());
        System.out.println("LOGGED = " + SessionManager.isLoggedIn());

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() >= 200
                && response.statusCode() < 300) {

            return gson.fromJson(
                    response.body(),
                    responseType
            );

        }
        System.out.println("STATUS = " + response.statusCode());
        System.out.println("BODY = " + response.body());


        ErrorResponse error =
                gson.fromJson(response.body(), ErrorResponse.class);

        if (error == null) {

            throw new ApiException(
                    response.statusCode(),
                    "UNKNOWN_ERROR",
                    "HTTP " + response.statusCode()
            );

        }

        throw new ApiException(
                response.statusCode(),
                error.getErrorCode(),
                error.getMessage()
        );

    }


    public static <T> T put(
            String endpoint,
            Object body,
            Type responseType
    )
            throws IOException,
            InterruptedException,
            ApiException {

        String json = gson.toJson(body);

        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(URI.create(ApiConfig.BASE_URL + endpoint))
                        .timeout(Duration.ofSeconds(
                                ApiConfig.REQUEST_TIMEOUT_SECONDS))
                        .header("Content-Type","application/json");

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );

        }

        HttpRequest request =
                builder.PUT(
                        HttpRequest.BodyPublishers.ofString(json)
                ).build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() >= 200 &&
                response.statusCode() < 300) {

            return gson.fromJson(
                    response.body(),
                    responseType
            );

        }

        ErrorResponse error =
                gson.fromJson(
                        response.body(),
                        ErrorResponse.class
                );

        throw new ApiException(
                response.statusCode(),
                error.getErrorCode(),
                error.getMessage()
        );

    }


    public static void patch(
            String endpoint,
            Object body
    )
            throws IOException,
            InterruptedException,
            ApiException {

        String json = gson.toJson(body);

        HttpRequest.Builder builder =
                HttpRequest.newBuilder()
                        .uri(URI.create(ApiConfig.BASE_URL + endpoint))
                        .timeout(Duration.ofSeconds(
                                ApiConfig.REQUEST_TIMEOUT_SECONDS))
                        .header("Content-Type","application/json");

        if (SessionManager.isLoggedIn()
                && SessionManager.getToken() != null) {

            builder.header(
                    "Authorization",
                    "Bearer " + SessionManager.getToken()
            );

        }

        HttpRequest request =
                builder.method(
                        "PATCH",
                        HttpRequest.BodyPublishers.ofString(json)
                ).build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() >= 200 &&
                response.statusCode() < 300) {

            return;

        }

        ErrorResponse error =
                gson.fromJson(
                        response.body(),
                        ErrorResponse.class
                );

        throw new ApiException(
                response.statusCode(),
                error.getErrorCode(),
                error.getMessage()
        );

    }



}