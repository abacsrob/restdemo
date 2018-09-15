package com.example.restdemo.controller.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> customerNotFoundException(CustomerNotFoundException e) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(
                Long.valueOf(HttpStatus.NOT_FOUND.value()),
                e.getMessage(), e.getUriString(),
                new Date().getTime());
        return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> genericException(Exception e) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(
                Long.valueOf(HttpStatus.BAD_REQUEST.value()),
                e.getMessage(), "",
                new Date().getTime());
        return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
