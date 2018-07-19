package com.exeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.service")
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EmailNotFoundException.class})
    public ResponseEntity<Object> emailNotFoundHandleConflict(Exception ex, WebRequest request) {
        String bodyOfResponse = "Your email address is not in the database. Please register";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {IncorrectPasswordException.class})
    public ResponseEntity<Object> incorrectPasswordHandleConflict(Exception ex, WebRequest request) {
        String bodyOfResponse = "You entered the wrong password. Try again";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {UserAlreadyExistException.class})
    public ResponseEntity<Object> userAlreadyExistHandleConflict(Exception ex, WebRequest request) {
        String bodyOfResponse = "The user with the given email already exists";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}
