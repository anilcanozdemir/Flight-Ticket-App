package com.example.Core.Exception.EntityListEmptyException;

import com.example.Core.Exception.EntityNotFoundException.EntityNotFoundException;

public abstract class EntityListEmptyException extends EntityNotFoundException {
    public EntityListEmptyException(String s) {
        super(s);
    }
}
