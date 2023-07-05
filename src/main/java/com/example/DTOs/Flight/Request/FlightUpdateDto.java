package com.example.DTOs.Flight.Request;

import com.example.Entity.Company;
import com.example.Enums.FlyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightUpdateDto {

    private int capacity;


    private Company company;

    private Long id;

    private FlyType flyType;
}
