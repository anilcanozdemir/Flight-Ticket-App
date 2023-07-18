package com.example.Core.Exception;

import com.example.Constants.BusinessConstants;

public class FlightNonAcceptableCapacityException extends RuntimeException {
    public FlightNonAcceptableCapacityException(int capacity) {
        super(capacity + "is non acceptable.Capacity must be a multiple of " + BusinessConstants.SEATS_PER_ROW);
    }
}
