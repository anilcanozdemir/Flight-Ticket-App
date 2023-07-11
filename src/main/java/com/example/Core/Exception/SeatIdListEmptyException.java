package com.example.Core.Exception;

public class SeatIdListEmptyException extends RuntimeException {
    public SeatIdListEmptyException() {
        super("SeatIdList is empty.");
    }
}
