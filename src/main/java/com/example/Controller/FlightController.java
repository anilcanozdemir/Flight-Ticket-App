package com.example.Controller;


import com.example.Core.Result.DataResult;
import com.example.Core.Result.Result;
import com.example.DTOs.Flight.Request.FlightAddedDto;
import com.example.DTOs.Flight.Request.FlightUpdateDto;
import com.example.DTOs.Flight.Response.FlightResponseDto;
import com.example.Service.Contrats.Service.FlightService;
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
    DataResult<List<FlightResponseDto>> getAll() {
        return this.flightService.getAll();

    }

    @GetMapping("/getById")
    DataResult<FlightResponseDto> getById(@RequestParam Long flightId) {
        return this.flightService.getById(flightId);

    }

    @PostMapping("/updateById")
    Result updateById(@RequestBody FlightUpdateDto flightUpdateDto) {
        return this.flightService.updateById(flightUpdateDto);

    }

    @PostMapping("/deleteById")
    DataResult<FlightResponseDto> deleteById(@RequestParam Long flightId) {
        return this.flightService.deleteByid(flightId);
    }
}
