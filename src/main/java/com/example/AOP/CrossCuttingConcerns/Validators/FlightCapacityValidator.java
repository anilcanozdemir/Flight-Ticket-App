package com.example.AOP.CrossCuttingConcerns.Validators;

import com.example.AOP.Annotations.FlightCapacityMustBeAMultiple;
import com.example.Constants.BusinessConstants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FlightCapacityValidator implements ConstraintValidator<FlightCapacityMustBeAMultiple, Integer> {


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % BusinessConstants.SEATS_PER_ROW == 0;

    }
}
