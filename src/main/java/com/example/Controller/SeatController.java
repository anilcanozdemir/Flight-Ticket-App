package com.example.Controller;


import com.example.Core.Result.DataResult;
import com.example.Core.Result.Result;
import com.example.DTOs.Seat.Request.SeatAddDto;
import com.example.DTOs.Seat.Request.SeatUpdateDto;
import com.example.DTOs.Seat.Response.SeatResponseDto;
import com.example.Service.Contrats.SeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/seat")
@RestController
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @PostMapping("/deleteById")
    ResponseEntity<DataResult<SeatResponseDto>> deleteById(@RequestParam Long seatId) {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.deleteByid(seatId));
    }

    @PostMapping("/add")
    ResponseEntity<Result> add(@Valid @RequestBody SeatAddDto seatAddedDto) {


        return ResponseEntity.status(HttpStatus.CREATED).body(this.seatService.add(seatAddedDto));
    }

    @GetMapping("/getAll")
    ResponseEntity<DataResult<List<SeatResponseDto>>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.getAll());
    }

    @GetMapping("/getAllByFlightId")
    ResponseEntity<DataResult<List<SeatResponseDto>>> getAll(@RequestParam Long flightId) {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.getAllByFlightId(flightId));
    }

    @GetMapping("/getById")
    ResponseEntity<DataResult<SeatResponseDto>> getById(@RequestParam Long seatId) {


        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.getById(seatId));
    }

    @GetMapping("/getByFlightIdAndSeatNumber")
    ResponseEntity<DataResult<SeatResponseDto>> getByFlightIdAndSeatNumber(@RequestParam String seatNumber, @RequestParam Long flightId) {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.getByFlightIdAndSeatNumber(seatNumber, flightId));
    }

    @PostMapping("/updateById")
    ResponseEntity<Result> updateById(@Valid @RequestBody SeatUpdateDto seatUpdateDto) {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.updateById(seatUpdateDto));
    }

    @GetMapping("/getPriceById")
    ResponseEntity<DataResult<Double>> getPriceById(@RequestParam Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.getPriceById(id));
    }

    @GetMapping("/getPriceByIdList")
    ResponseEntity<DataResult<Double>> getPriceByIdList(@RequestBody List<Long> idList) {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.getPriceByIdList(idList));
    }

    @GetMapping("/buyById")
    ResponseEntity<DataResult<Double>> buyById(@RequestParam Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.buyById(id));
    }

    @GetMapping("/buyByIdList")
    ResponseEntity<DataResult<Double>> buyByIdList(@RequestBody List<Long> idList) {

        return ResponseEntity.status(HttpStatus.OK).body(this.seatService.buyByIdList(idList));
    }
}
