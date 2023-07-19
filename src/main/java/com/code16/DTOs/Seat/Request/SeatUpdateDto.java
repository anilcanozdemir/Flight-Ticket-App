package com.code16.DTOs.Seat.Request;


import com.code16.Enums.SeatType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatUpdateDto {
    @NotNull(message = "seatId can not be empty")
    private Long seatId;
    @NotNull(message = "seatId can not be empty")
    private Long flightId;
    //TODO seatNumber regex Validation
    @NotNull(message = "seatId can not be empty")
    private String seatNumber;
    @NotNull(message = "fullled can not be empty")
    private boolean fullled;
    @NotNull(message = "SeatType can not be empty")
    //   @ValueOfEnum(enumClass = SeatType.class,message = "Invalid term Seat Type")
    private SeatType seatType;

}
