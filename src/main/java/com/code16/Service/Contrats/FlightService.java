package com.code16.Service.Contrats;

import com.code16.DTOs.Flight.Request.FlightAddedDto;
import com.code16.DTOs.Flight.Request.FlightUpdateDto;
import com.code16.DTOs.Flight.Response.FlightResponseDto;

public interface FlightService extends BaseService<FlightResponseDto, FlightAddedDto, FlightUpdateDto> {
}
