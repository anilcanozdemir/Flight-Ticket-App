package com.code16.Controller;


import com.code16.Core.Result.DataResult;
import com.code16.Core.Result.Result;
import com.code16.DTOs.Flight.Request.FlightAddedDto;
import com.code16.DTOs.Flight.Request.FlightUpdateDto;
import com.code16.DTOs.Flight.Response.FlightResponseDto;
import com.code16.Service.Contrats.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/flight")
@RestController
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @PostMapping("/add")
    ResponseEntity<Result> add(@Valid @RequestBody FlightAddedDto flightAddedDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.flightService.add(flightAddedDto));
    }

    @GetMapping("/getAll")
    ResponseEntity<DataResult<List<FlightResponseDto>>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(this.flightService.getAll());

    }

    @GetMapping("/getById")
    ResponseEntity<DataResult<FlightResponseDto>> getById(@RequestParam Long flightId) {

        return ResponseEntity.status(HttpStatus.OK).body(this.flightService.getById(flightId));

    }

    @PostMapping("/updateById")
    ResponseEntity<Result> updateById(@Valid @RequestBody FlightUpdateDto flightUpdateDto) {

        return ResponseEntity.status(HttpStatus.OK).body(this.flightService.updateById(flightUpdateDto));
    }

    @PostMapping("/deleteById")
    ResponseEntity<DataResult<FlightResponseDto>> deleteById(@RequestParam Long flightId) {

        return ResponseEntity.status(HttpStatus.OK).body(this.flightService.deleteByid(flightId));
    }
}
