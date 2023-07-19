package com.code16.AOP.CrossCuttingConcerns.Validators;

import com.code16.AOP.Annotations.FlightCapacityMustBeAMultiple;
import com.code16.Constants.BusinessConstants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FlightCapacityValidator implements ConstraintValidator<FlightCapacityMustBeAMultiple, Integer> {


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % BusinessConstants.SEATS_PER_ROW == 0;

    }
}
