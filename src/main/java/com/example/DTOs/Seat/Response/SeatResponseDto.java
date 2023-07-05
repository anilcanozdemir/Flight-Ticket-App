package com.example.DTOs.Seat.Response;

import com.example.Entity.Flight;
import com.example.Enums.SeatNumber;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatResponseDto {

    private Long id;


    private Long flightId;

    private SeatNumber seatNumber;

    private boolean empty;
}
