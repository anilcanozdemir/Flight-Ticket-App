package com.example.AOP.Validators;

import com.example.AOP.Aspects.BusinessCapacityCantExceedFlightCapacity;
import com.example.DTOs.Flight.Request.FlightAddedDto;
import com.example.DTOs.Flight.Request.FlightUpdateDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BusinessCapacityCantExceedFlightCapacityValidator implements ConstraintValidator<BusinessCapacityCantExceedFlightCapacity, Object> {
    @Override
    public void initialize(BusinessCapacityCantExceedFlightCapacity constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof FlightAddedDto) {
            return ((FlightAddedDto) value).getCapacity() > ((FlightAddedDto) value).getBusinessCapacity();
        } else if (value instanceof FlightUpdateDto) {
            return ((FlightUpdateDto) value).getCapacity() > ((FlightUpdateDto) value).getBusinessCapacity();
        }
        return false;
    }
}
