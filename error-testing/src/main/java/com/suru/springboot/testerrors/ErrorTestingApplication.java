package com.suru.springboot.testerrors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class ErrorTestingApplication {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            container.addErrorPages(errorPage);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ErrorTestingApplication.class, args);
    }
}
