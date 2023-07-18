package com.example.Core.Result;

public class SuccessDataResult<Data> extends DataResult<Data> {

    public SuccessDataResult() {
        super(true);
    }

    public SuccessDataResult(Data data) {
        super(true, data);
    }

    public SuccessDataResult(String message) {
        super(true, message);
    }

    public SuccessDataResult(String message, Data data) {
        super(true, message, data);
    }
}
