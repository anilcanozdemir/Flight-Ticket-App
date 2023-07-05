package com.example.DTOs.Seat.Request;

import com.example.Entity.Flight;
import com.example.Enums.SeatNumber;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatAddDto {


    private Flight flight;

    private SeatNumber seatNumber;


}
