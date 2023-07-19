package com.code16.Core.Exception;

import com.code16.Constants.BusinessConstants;

public class FlightNonAcceptableCapacityException extends RuntimeException {
    public FlightNonAcceptableCapacityException(int capacity) {
        super(capacity + "is non acceptable.Capacity must be a multiple of " + BusinessConstants.SEATS_PER_ROW);
    }
}
