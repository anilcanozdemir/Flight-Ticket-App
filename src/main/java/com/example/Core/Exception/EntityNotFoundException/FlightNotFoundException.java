package com.example.Core.Exception.EntityNotFoundException;

public class FlightNotFoundException extends EntityNotFoundException {
    public FlightNotFoundException(Long flightId) {
        super("FlightId  :" + flightId + " is not found.");
    }
}
