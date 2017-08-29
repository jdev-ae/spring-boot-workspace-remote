package com.suru.sbootest1.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final TestBuilder testB;
    private NotificationService notificationService;

    @Autowired
    public UserController(NotificationService notificationService, @Qualifier("testB") TestBuilder testBuilder) {
        this.notificationService = notificationService;
        this.testB = testBuilder;
    }

    @RequestMapping("/")
    public String home() {
        return notificationService.getData() + " > " + testB.getTestString();
    }

    @Value("${myApp.env}")
    private String env;

    @RequestMapping("/env")
    public String getEnv() {
        return env;
    }

}
