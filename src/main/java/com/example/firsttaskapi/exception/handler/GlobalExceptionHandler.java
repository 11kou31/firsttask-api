package com.example.firsttaskapi.exception.handler;

import com.example.firsttaskapi.exception.FighterNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FighterNotFoundException.class)
    public ResponseEntity<String> handleFighterNotFoundException(FighterNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}