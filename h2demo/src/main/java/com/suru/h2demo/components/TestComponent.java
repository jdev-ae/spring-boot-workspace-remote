package com.suru.h2demo.components;

import com.suru.h2demo.model.Author;
import com.suru.h2demo.repositories.AuthorRepository;
import com.suru.h2demo.repositories.PostRepository;
import com.suru.h2demo.services.DataLoaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class TestComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestComponent.class);

    @Autowired
    private DataLoaderService dataLoaderService;

    public TestComponent() {
        LOGGER.info("test");
    }

    @PostConstruct
    public void initTest() {
//        LOGGER.info("add data call");
//        dataLoaderService.addData();
        LOGGER.info("print data call");
        dataLoaderService.printAuthors();
    }
}
