package com.suru.stopatstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StopAtStartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StopAtStartApplication.class, args);
    }
}
