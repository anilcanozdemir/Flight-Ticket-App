package com.code16.Core.Result;


public abstract class DataResult<Data> extends Result {


    private Data data;

    public DataResult(boolean success) {
        super(success);
    }

    public DataResult(boolean success, Data data) {
        super(success);
        this.data = data;
    }

    public DataResult(boolean success, String message) {
        super(success, message);
    }

    public DataResult(boolean success, String message, Data data) {
        super(success, message);
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
