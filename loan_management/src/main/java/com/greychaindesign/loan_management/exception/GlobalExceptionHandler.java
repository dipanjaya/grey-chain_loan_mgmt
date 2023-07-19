package com.greychaindesign.loan_management.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InvalidLoanException.class)
    public ResponseEntity<?> handleUserAuthenticationException(InvalidLoanException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<?> handleUserAuthenticationException(EntityNotFoundException e){
        return ResponseEntity.badRequest().body("Requested entity is not found.");
    }
}
