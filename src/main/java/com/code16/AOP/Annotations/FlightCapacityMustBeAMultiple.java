package com.code16.AOP.Annotations;


import com.code16.AOP.CrossCuttingConcerns.Validators.FlightCapacityValidator;
import com.code16.Constants.BusinessConstants;
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
