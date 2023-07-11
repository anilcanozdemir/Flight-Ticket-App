package com.example.Service.Contrats.Service;

import com.example.DTOs.Flight.Request.FlightAddedDto;
import com.example.DTOs.Flight.Request.FlightUpdateDto;
import com.example.DTOs.Flight.Response.FlightResponseDto;

public interface FlightService extends BaseService<FlightResponseDto, FlightAddedDto, FlightUpdateDto> {
}
