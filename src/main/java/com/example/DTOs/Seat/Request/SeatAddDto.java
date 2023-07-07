package com.example.DTOs.Seat.Request;

import com.example.Entity.Flight;
import com.example.Enums.SeatNumber;
import com.example.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatAddDto {



    private Long id;


    private Long flightId;
    @Column
    private String seatNumber;
    @Column
    private boolean fullled;

    private SeatType seatType;

}
