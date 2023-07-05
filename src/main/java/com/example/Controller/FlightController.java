package com.example.Controller;


import com.example.DTOs.Flight.Request.FlightAddedDto;
import com.example.DTOs.Flight.Request.FlightUpdateDto;
import com.example.DTOs.Flight.Response.FlightResponseDto;
import com.example.Service.Contrats.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/flight")
@RestController
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @PostMapping("/add")
    void add(@RequestBody FlightAddedDto flightAddedDto) {
        this.flightService.add(flightAddedDto);
    }

    @GetMapping("/getAll")
    List<FlightResponseDto> getAll() {
        return this.flightService.getAll();

    }

    @GetMapping("/getById")
    FlightResponseDto getById(@RequestParam Long flightId) {
        return this.flightService.getById(flightId);

    }

    @PostMapping("/updateById")
    void updateById(@RequestBody FlightUpdateDto flightUpdateDto) {
        this.flightService.updateById(flightUpdateDto);

    }

    @PostMapping("/deleteById")
    FlightResponseDto deleteById(@RequestParam Long flightId) {
        return this.flightService.deleteByid(flightId);
    }
}
