package com.code16.Core.Exception.EntityAlreadyExist;

public abstract class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String s) {
        super(s);
    }
}
