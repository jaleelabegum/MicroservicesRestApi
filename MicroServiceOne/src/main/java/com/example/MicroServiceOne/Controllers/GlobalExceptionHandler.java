package com.example.MicroServiceOne.Controllers;

import com.example.MicroServiceOne.Utilities.UserNotInDatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotInDatabaseException.class)
    public ResponseEntity<String> UserNotFound(UserNotInDatabaseException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
