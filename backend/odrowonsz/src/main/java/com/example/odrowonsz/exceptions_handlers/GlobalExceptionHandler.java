package com.example.odrowonsz.exceptions_handlers;

import com.example.odrowonsz.exceptions.ForbiddenException;
import com.example.odrowonsz.exceptions.EntityNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("message1", "An error occurred");
        body.put("message2", "An error occurred");
        body.put("message3", "An error occurred");

        return new ResponseEntity<>(body, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);

    }
    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<Object> handleNotFoundException(EntityNotFound e) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
