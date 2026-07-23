package com.secondhand.backend.config;

import com.secondhand.backend.security.CustomUserDetailsService;
import com.secondhand.backend.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .authorizeHttpRequests(auth -> auth

                        /*
                         * Public Authentication APIs
                         */

                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/auth/login",
                                "/api/auth/register"
                        ).permitAll()

                        .requestMatchers(
                                HttpMethod.GET,
                                "/ping"
                        ).permitAll()

                        /*
                         * Public Advertisement APIs
                         */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/advertisements",
                                "/api/advertisements/**"
                        ).permitAll()

                        /*
                         * Public Category APIs
                         */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/categories/**"
                        ).permitAll()

                        /*
                         * Public Province APIs
                         */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/provinces/**"
                        ).permitAll()

                        /*
                         * Public City APIs
                         */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/cities/**"
                        ).permitAll()

                        /*
                         * Public User APIs
                         */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/users/sellers/**"
                        ).permitAll()

                        /*
                         * Public Rating APIs
                         */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/ratings/seller/**"
                        ).permitAll()

                        /*
                         * Admin APIs
                         */

                        .requestMatchers(
                                "/api/admin/**"
                        ).hasRole("ADMIN")

                        /*
                         * Everything else requires authentication
                         */

                        .anyRequest()
                        .authenticated()

                )

                .authenticationProvider(authenticationProvider())

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                )

                .formLogin(form -> form.disable())

                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}