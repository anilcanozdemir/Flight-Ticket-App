package com.example.DTOs.Flight.Request;

import com.example.AOP.Aspects.BusinessCapacityCantExceedFlightCapacity;
import com.example.AOP.Aspects.FlightCapacityMustBeAMultiple;
import com.example.Enums.FlyType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@BusinessCapacityCantExceedFlightCapacity
public class FlightUpdateDto {

    @NotNull(message = "capacity can not be empty")
    @FlightCapacityMustBeAMultiple
    private int capacity;

    @NotNull(message = "companyId can not be empty")
    private Long companyId;
    @NotNull(message = "flightId can not be empty")

    private Long flightId;
    @NotNull(message = "flyType can not be empty")

   // @ValueOfEnum(enumClass = FlyType.class,message = "Invalid term Fly Type")
    private FlyType flyType;
    @NotNull(message = "price can not be empty")
    private double price;
    @NotNull(message = "businessExtra can not be empty")
    private double businessExtra;

    @NotNull(message = "businessCapacity can not be empty")
    private int businessCapacity;
}
