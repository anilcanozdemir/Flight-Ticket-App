package com.code16.Core.Exception.EntityListEmptyException;

public class SeatListEmptyException extends EntityListEmptyException {
    public SeatListEmptyException(Long flightId) {
        super("SeatList  with Flight id" + flightId + "is empty.");
    }

    public SeatListEmptyException() {
        super("SeatList is empty.");
    }
}
