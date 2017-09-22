package com.suru.h2demo;

import com.suru.h2demo.model.Author;
import com.suru.h2demo.model.Post;
import com.suru.h2demo.repositories.AuthorRepository;
import com.suru.h2demo.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// Using in memory h2 database
// JDBC URL: jdbc:h2:mem:testdb

@SpringBootApplication
@EntityScan(basePackages = {"com.suru.h2demo.model"})
public class H2demoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(H2demoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(H2demoApplication.class, args);
    }

}
