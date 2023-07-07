package com.example.DTOs.Seat.Request;


import com.example.Enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatUpdateDto {

    private Long id;


    private Long flightId;

    private String seatNumber;
    private boolean fullled;
    private SeatType seatType;

}
