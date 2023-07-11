package com.example.Core.Exception.EntityListEmptyException;

public class SeatListEmptyException extends EntityListEmptyException {
    public SeatListEmptyException(Long flightId) {
        super("SeatList  with Flight id" + flightId + "is empty.");
    }
}
