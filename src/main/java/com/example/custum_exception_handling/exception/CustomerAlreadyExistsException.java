package com.example.custum_exception_handling.exception;

//Creating a custom exception that can be thrown when a user tries to add a customer that already exists
public class CustomerAlreadyExistsException extends RuntimeException {
    private String message;

    public CustomerAlreadyExistsException() {}

    public CustomerAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
