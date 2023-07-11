package com.example.DTOs.Seat.Request;

import com.example.Enums.SeatType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatAddDto {




    private Long flightId;
    @Column
    private String seatNumber;
    @Column
    private boolean fullled;

    private SeatType seatType;

}
