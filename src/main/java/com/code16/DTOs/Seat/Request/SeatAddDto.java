package com.code16.DTOs.Seat.Request;

import com.code16.Enums.SeatType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatAddDto {


    @NotNull(message = "flightId can not be empty")

    private Long flightId;
    @NotNull(message = "seatNumber can not be empty")
    //TODO seatNumber regex Validation
    private String seatNumber;
    @NotNull(message = "fullled can not be empty")
    private boolean fullled;
    @NotNull(message = "seatType can not be empty")

    //  @ValueOfEnum(enumClass = SeatType.class,message = "Invalid term Seat Type")
    private SeatType seatType;

}
