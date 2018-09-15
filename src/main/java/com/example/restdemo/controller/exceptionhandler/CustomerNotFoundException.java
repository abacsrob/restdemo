package com.example.restdemo.controller.exceptionhandler;

import lombok.Getter;

@Getter
public class CustomerNotFoundException extends RuntimeException {

    private String uriString;

    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, String uriPath) {
        this(message);
        this.uriString = uriPath;
    }
}
