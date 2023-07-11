package com.example.Service.Contrats.Service;

import com.example.Core.Result.DataResult;
import com.example.Core.Result.Result;
import com.example.DTOs.Seat.Request.SeatAddDto;
import com.example.DTOs.Seat.Request.SeatUpdateDto;
import com.example.DTOs.Seat.Response.SeatResponseDto;

import java.util.List;

public interface SeatService extends BaseService<SeatResponseDto, SeatAddDto, SeatUpdateDto> {
    DataResult<List<SeatResponseDto>> getAllByFlightId(Long flightId);

    Result add(Long id, int capacity);

    DataResult<Double> getPriceById(Long id);
    DataResult<Double> getPriceByIdList(List<Long> idList);

    DataResult<Double> buyById(Long id);

    DataResult<Double> buyByIdList(List<Long> idList);

    DataResult<SeatResponseDto> getByFlightIdAndSeatNumber(String seatNumber, Long flightId);
}
