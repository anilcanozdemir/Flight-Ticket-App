package com.code16.Core.Exception;

public class SeatIdListEmptyException extends RuntimeException {
    public SeatIdListEmptyException() {
        super("SeatIdList is empty.");
    }
}
