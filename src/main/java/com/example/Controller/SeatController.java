package com.example.Controller;


import com.example.Core.Result.DataResult;
import com.example.Core.Result.Result;
import com.example.DTOs.Seat.Request.SeatAddDto;
import com.example.DTOs.Seat.Request.SeatUpdateDto;
import com.example.DTOs.Seat.Response.SeatResponseDto;
import com.example.Service.Contrats.Service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/seat")
@RestController
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @PostMapping("/deleteById")
    DataResult<SeatResponseDto> deleteById(@RequestParam Long seatId) {
        return this.seatService.deleteByid(seatId);
    }

    @PostMapping("/add")
    Result add(SeatAddDto seatAddedDto) {
        return this.seatService.add(seatAddedDto);
    }

    @GetMapping("/getAll")
    DataResult<List<SeatResponseDto>> getAll() {
        return this.seatService.getAll();

    }

    @GetMapping("/getAllByFlightId")
    DataResult<List<SeatResponseDto>> getAll(@RequestParam Long flightId) {
        return this.seatService.getAllByFlightId(flightId);

    }

    @GetMapping("/getById")
    DataResult<SeatResponseDto> getById(@RequestParam Long seatId) {
        return this.seatService.getById(seatId);

    }

    @GetMapping("/getByFlightIdAndSeatNumber")
    DataResult<SeatResponseDto> getByFlightIdAndSeatNumber(@RequestParam String seatNumber, @RequestParam Long flightId) {
        return this.seatService.getByFlightIdAndSeatNumber(seatNumber, flightId);

    }

    @PostMapping("/updateById")
    Result updateById(@RequestBody SeatUpdateDto seatUpdateDto) {
        return this.seatService.updateById(seatUpdateDto);

    }

    @GetMapping("/getPriceById")
    DataResult<Double> getPriceById(@RequestParam Long id) {
        return this.seatService.getPriceById(id);
    }

    @GetMapping("/getPriceByIdList")
    DataResult<Double> getPriceByIdList(@RequestBody List<Long> idList) {
        return this.seatService.getPriceByIdList(idList);
    }

    @GetMapping("/buyById")
    DataResult<Double> buyById(@RequestParam Long id) {
        return this.seatService.buyById(id);
    }

    @GetMapping("/buyByIdList")
    DataResult<Double> buyByIdList(@RequestBody List<Long> idList) {
        return this.seatService.buyByIdList(idList);
    }
}
