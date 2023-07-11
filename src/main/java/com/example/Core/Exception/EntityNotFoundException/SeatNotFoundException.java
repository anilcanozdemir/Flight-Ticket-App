package com.example.Core.Exception.EntityNotFoundException;

public class SeatNotFoundException extends EntityNotFoundException {
    public SeatNotFoundException(Long seatId) {
        super("SeatId  :"+seatId+" is not found.");
    }

    public SeatNotFoundException(String seatNumber, Long flightId) {
        super("Seat with Id  :"+seatNumber+"and flightId"+flightId+" is not found.");
    }
}
