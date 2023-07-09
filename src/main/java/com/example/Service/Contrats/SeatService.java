package com.example.Service.Contrats;

import com.example.DTOs.Seat.Request.SeatAddDto;
import com.example.DTOs.Seat.Request.SeatUpdateDto;
import com.example.DTOs.Seat.Response.SeatResponseDto;

import java.util.List;

public interface SeatService extends BaseService<SeatResponseDto, SeatAddDto, SeatUpdateDto> {
    List<SeatResponseDto> getAllByFlightId(Long flightId);

    void add(Long id, int capacity);

    double getPriceById(Long id);
    double getPriceByIdList(List<Long> idList);

    double buyById(Long id);

    double buyByIdList(List<Long> idList);

    SeatResponseDto getByFlightIdAndSeatNumber(String seatNumber, Long flightId);
}
