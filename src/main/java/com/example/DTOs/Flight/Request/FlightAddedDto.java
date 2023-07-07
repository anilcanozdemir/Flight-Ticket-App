package com.example.DTOs.Flight.Request;

import com.example.Entity.Company;

import com.example.Enums.FlyType;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FlightAddedDto {

    private int capacity;
    private Long companyId;
    private FlyType flyType;
    private double price;
    private double businessExtra;
    private int businessCapacity;
}
