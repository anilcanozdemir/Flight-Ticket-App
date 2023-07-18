package com.example.AOP.Validators;

import com.example.AOP.Aspects.FlightCapacityMustBeAMultiple;
import com.example.Constants.Constants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FlightCapacityValidator implements ConstraintValidator<FlightCapacityMustBeAMultiple, Integer> {


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % Constants.SEATS_PER_ROW == 0;

    }
}