package com.example.custum_exception_handling.exception;
//Class to handle exceptions globally


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(value = NoSuchCustomerExistsException.class)
 @ResponseStatus(HttpStatus.NOT_FOUND)
 public @ResponseBody ErrorResponse handleException(NoSuchCustomerExistsException ex) {
     return new ErrorResponse(ex.getMessage());
 }
}

