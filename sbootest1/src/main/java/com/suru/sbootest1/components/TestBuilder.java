package com.suru.sbootest1.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("testB")
public class TestBuilder {

    private String message;
    private String data;
    private int number;

    public String getTestString() {
        return "Hello Test Builder: " + message + " > " + data + ": " + number;
    }

    @Autowired
    public void setMessage(@Value("${myApp.message}") String message) {
        this.message = message;
    }

    @Autowired
    public void setData(@Value("${myApp.data}") String data) {
        this.data = data;
    }

    @Autowired
    public void setNumber(@Value("${myApp.number}") int number) {
        this.number = number;
    }
}
