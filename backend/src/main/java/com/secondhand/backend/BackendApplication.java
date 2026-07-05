package com.secondhand.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        logger.info("Starting SecondHand Marketplace Backend...");
        SpringApplication.run(BackendApplication.class, args);
    }
    private static final Logger logger =
            LoggerFactory.getLogger(BackendApplication.class);

}

