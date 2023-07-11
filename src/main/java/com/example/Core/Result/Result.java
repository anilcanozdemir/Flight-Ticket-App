package com.example.Core.Result;

public abstract class Result {
    public Result(boolean success)
    {
        this.success=success;
    }
    public Result(boolean success,
                  String message)
    {
        this(success);
        this.message=message;
    }


    private boolean success;
    private String message;




    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
