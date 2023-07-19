package com.code16.Core.Exception.EntityListEmptyException;

import com.code16.Core.Exception.EntityNotFoundException.EntityNotFoundException;

public abstract class EntityListEmptyException extends EntityNotFoundException {
    public EntityListEmptyException(String s) {
        super(s);
    }
}
