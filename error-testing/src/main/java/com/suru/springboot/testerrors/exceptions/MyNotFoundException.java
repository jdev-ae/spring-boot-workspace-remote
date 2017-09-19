package com.suru.springboot.testerrors.exceptions;

public class MyNotFoundException extends Exception {
    public MyNotFoundException(String message) {
        super("MyNotFoundException with: " + message);
    }
}
