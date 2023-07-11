package com.example.Core.Exception;

import com.example.Constants.Constants;

public class FlightNonAcceptableCapacityException extends RuntimeException {
    public FlightNonAcceptableCapacityException(int capacity) {
        super(capacity+"is non acceptable.Capacity must be a multiple of "+ Constants.SEATS_PER_ROW);
    }
}
