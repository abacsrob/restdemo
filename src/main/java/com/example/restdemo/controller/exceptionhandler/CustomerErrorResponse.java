package com.example.restdemo.controller.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerErrorResponse {

    private Long statusCode;
    private String message;
    private String uriString;
    private long timestamp;

    public CustomerErrorResponse(Long statusCode, String message, String uriString, long timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.uriString = uriString;
        this.timestamp = timestamp;
    }
}
