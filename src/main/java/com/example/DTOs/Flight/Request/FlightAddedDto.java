package com.example.DTOs.Flight.Request;

import com.example.AOP.Annotations.BusinessCapacityCantExceedFlightCapacity;
import com.example.AOP.Annotations.FlightCapacityMustBeAMultiple;
import com.example.Enums.FlyType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@BusinessCapacityCantExceedFlightCapacity
public class FlightAddedDto {
    @NotNull(message = "capacity can not be empty")
    @FlightCapacityMustBeAMultiple
    private int capacity;
    @NotNull(message = "companyId can not be empty")

    private Long companyId;

    // @ValueOfEnum(enumClass = FlyType.class,message = "Invalid term Fly Type")
    private FlyType flyType;
    @NotNull(message = "price can not be empty")
    private double price;
    @NotNull(message = "businessExtra can not be empty")
    private double businessExtra;

    @NotNull(message = "businessExtra can not be empty")
    private int businessCapacity;
}
