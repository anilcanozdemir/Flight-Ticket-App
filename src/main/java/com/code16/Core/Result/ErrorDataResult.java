package com.code16.Core.Result;


public class ErrorDataResult<Data> extends DataResult<Data> {
    public ErrorDataResult() {
        super(false);
    }

    public ErrorDataResult(Data data) {
        super(false, data);
    }

    public ErrorDataResult(String message) {
        super(false, message);
    }

    public ErrorDataResult(String message, Data data) {
        super(false, message, data);
    }
}
