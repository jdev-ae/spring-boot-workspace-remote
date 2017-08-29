package com.suru.sbootest1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan({"com.suru.sbootest1.components"})
public class SBootTest1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SBootTest1Application.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.sort(beanDefinitionNames);
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
    }
}
