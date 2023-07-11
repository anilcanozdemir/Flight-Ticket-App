package com.example.ExceptionHandler;


import com.example.Core.Exception.EntityAlreadyExist.CompanyAlreadyExistsException;
import com.example.Core.Exception.EntityAlreadyExist.EntityAlreadyExistsException;
import com.example.Core.Exception.EntityListEmptyException.EntityListEmptyException;
import com.example.Core.Exception.EntityNotFoundException.EntityNotFoundException;
import com.example.Core.Exception.FlightNonAcceptableCapacityException;
import com.example.Core.Exception.SeatIdListEmptyException;
import com.example.Core.Result.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerConfig {




    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorResult> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResult(exception.getMessage()));
    }
    @ExceptionHandler({FlightNonAcceptableCapacityException.class})
    public ResponseEntity<ErrorResult> handleFlightNonAcceptableCapacityException(FlightNonAcceptableCapacityException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResult(exception.getMessage()));
    }
    @ExceptionHandler({SeatIdListEmptyException.class})
    public ResponseEntity<ErrorResult> handleSeatIdListEmptyException(SeatIdListEmptyException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResult(exception.getMessage()));
    }
    @ExceptionHandler({EntityAlreadyExistsException.class})
    public ResponseEntity<ErrorResult> handleEntityAlreadyExistsException(EntityAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResult(exception.getMessage()));
    }
    @ExceptionHandler({EntityListEmptyException.class})
    public ResponseEntity<ErrorResult> handleEntityListEmptyException(EntityListEmptyException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResult(exception.getMessage()));
    }

}
