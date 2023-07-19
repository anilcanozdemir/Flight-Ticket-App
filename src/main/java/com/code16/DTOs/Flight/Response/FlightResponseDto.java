package com.code16.DTOs.Flight.Response;


import com.code16.Enums.FlyType;
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
