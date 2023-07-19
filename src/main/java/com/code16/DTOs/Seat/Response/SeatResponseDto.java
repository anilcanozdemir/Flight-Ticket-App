package com.code16.DTOs.Seat.Response;


import com.code16.Enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatResponseDto {

    private Long seatId;


    private Long flightId;

    private String seatNumber;
    private boolean fullled;
    private SeatType seatType;
}
