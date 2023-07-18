package com.example.AOP.Aspects;


import com.example.AOP.Validators.FlightCapacityValidator;
import com.example.Constants.BusinessConstants;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {FlightCapacityValidator.class})
public @interface FlightCapacityMustBeAMultiple {
    String message() default "FlightCapacity must be a value which is a multiple of SEATS_PER_ROW\t" + BusinessConstants.SEATS_PER_ROW;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
