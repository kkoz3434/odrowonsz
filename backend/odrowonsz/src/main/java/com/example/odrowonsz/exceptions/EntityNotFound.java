package com.example.odrowonsz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFound extends RuntimeException {
    private final Class<?> clazz;
    public EntityNotFound(Class<?> objectClass) {
        this.clazz = objectClass;
    }

    @Override
    public String getMessage() {
        return "Entity not found (" + clazz.getSimpleName() + ")";
    }
}
