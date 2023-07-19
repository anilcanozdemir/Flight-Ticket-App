package com.example.ExceptionHandler;


import com.example.Core.Exception.EntityAlreadyExist.EntityAlreadyExistsException;
import com.example.Core.Exception.EntityListEmptyException.EntityListEmptyException;
import com.example.Core.Exception.EntityNotFoundException.EntityNotFoundException;
import com.example.Core.Exception.FlightNonAcceptableCapacityException;
import com.example.Core.Exception.SeatIdListEmptyException;
import com.example.Core.Result.ErrorDataResult;
import com.example.Core.Result.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerConfig {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDataResult<Map<String, String>>> handleExceptionForValidation(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();
        ErrorDataResult<Map<String, String>> errorDataResult = new ErrorDataResult<>("Validasyon kuralları", validationErrors);
        if (!exception.getGlobalErrors().isEmpty()) {
            for (ObjectError objectError : exception.getBindingResult().getGlobalErrors()) {
                validationErrors.put(objectError.getObjectName(), objectError.getDefaultMessage());
            }
        }
        if (!exception.getFieldErrors().isEmpty()) {
            for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        errorDataResult.setData(validationErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDataResult);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResult> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorResult> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResult(exception.getMessage()));
       // return new ResponseEntity<>(new ErrorResult(exception.getMessage()),HttpStatus.BAD_REQUEST);
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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResult(exception.getMessage()));
    }

}
