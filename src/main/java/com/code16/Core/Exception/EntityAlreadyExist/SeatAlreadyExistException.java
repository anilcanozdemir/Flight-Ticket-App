package com.code16.Core.Exception.EntityAlreadyExist;

public class SeatAlreadyExistException extends EntityAlreadyExistsException {
    public SeatAlreadyExistException(Long flightId, String seatNumber) {
        super("Seat with Id  :" + seatNumber + "and flightId" + flightId + "  already exists.");
    }
}
