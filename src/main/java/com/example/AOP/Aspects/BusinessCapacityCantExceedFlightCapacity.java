package com.example.AOP.Aspects;

import com.example.AOP.Validators.BusinessCapacityCantExceedFlightCapacityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {BusinessCapacityCantExceedFlightCapacityValidator.class})
public @interface BusinessCapacityCantExceedFlightCapacity {
    String message() default "Flight capacity must be greater than business capacity.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
