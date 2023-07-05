package com.example.Controller;


import com.example.DTOs.Seat.Request.SeatAddDto;
import com.example.DTOs.Seat.Request.SeatUpdateDto;
import com.example.DTOs.Seat.Response.SeatResponseDto;
import com.example.Service.Contrats.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/seat")
@RestController
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;
    public void add(Long id, int capacity) {
        this.seatService.add(id,capacity);
    }
    @PostMapping("/add")
    void add( SeatAddDto seatAddedDto) {
        this.seatService.add(seatAddedDto);
    }

    @GetMapping("/getAll")
    List<SeatResponseDto> getAll() {
        return this.seatService.getAll();

    }
    @GetMapping("/getAllByFlightId")
    List<SeatResponseDto> getAll(@RequestParam Long flightId) {
        return this.seatService.getAllByFlightId(flightId);

    }
    @GetMapping("/getById")
    SeatResponseDto getById(@RequestParam Long seatId) {
        return this.seatService.getById(seatId);

    }

    @PostMapping("/updateById")
    void updateById(@RequestBody SeatUpdateDto seatUpdateDto) {
        this.seatService.updateById(seatUpdateDto);

    }

    @PostMapping("/deleteById")
    SeatResponseDto deleteById(@RequestParam Long seatId) {
        return this.seatService.deleteByid(seatId);
    }


}
