package com.example.DTOs.Flight.Response;


import com.example.Enums.FlyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightResponseDto {

    private int capacity;


    private Long companyId;

    private Long flightId;

    private FlyType flyType;

    private double price;

    private double businessExtra;

    private int businessCapacity;

    //  private List<SeatResponseDto> seatList;
}
