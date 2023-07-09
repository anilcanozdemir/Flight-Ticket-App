package com.example.Core.Result;

public class SuccessResult<T> extends Result {
    private T value;

    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }

    public T getT() {
        return value;
    }

    public void setT(T value) {
        this.value = value;
    }

}
