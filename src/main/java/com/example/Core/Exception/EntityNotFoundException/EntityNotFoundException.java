package com.example.Core.Exception.EntityNotFoundException;

public abstract class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException(String s) {
        super(s);
    }
    public EntityNotFoundException(Long s) {
        super(String.valueOf(s));
    }
}
