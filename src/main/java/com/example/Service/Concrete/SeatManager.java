package com.example.Service.Concrete;


import com.example.Constants.Constants;
import com.example.DTOs.Seat.Request.SeatAddDto;
import com.example.DTOs.Seat.Request.SeatUpdateDto;
import com.example.DTOs.Seat.Response.SeatResponseDto;
import com.example.Entity.Flight;
import com.example.Entity.Seat;
import com.example.Enums.SeatNumber;
import com.example.Enums.SeatType;
import com.example.Repository.SeatRepository;
import com.example.Service.Contrats.FlightService;
import com.example.Service.Contrats.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class SeatManager implements SeatService {

    private final SeatRepository seatRepository;
    private final ModelMapper modelMapper;

    private final FlightService flightService;

    public SeatManager(SeatRepository seatRepository,
                       ModelMapper modelMapper,
                       @Lazy FlightService flightService) {
        this.seatRepository = seatRepository;
        this.modelMapper = modelMapper;
        this.flightService = flightService;
    }

    @Override
    public void add(Long id, int capacity) {
        String[] seatNumbers = SeatNumber.generateSeatNumbers(capacity / Constants.SEATS_PER_ROW, Constants.SEATS_PER_ROW);
        for (int i = 0; i < capacity; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber(seatNumbers[i]);
            if (i < this.flightService.getById(id).getBusinessCapacity()) {
                seat.setSeatType(SeatType.BUSINESS);
            } else {
                seat.setSeatType(SeatType.ECONOMY);
            }
            seat.setFullled(false);
            seat.setFlight(modelMapper.map(this.flightService.getById(id), Flight.class));

            this.seatRepository.save(seat);
        }
    }

    @Override
    public void add(SeatAddDto seatAddDto) {
        this.seatRepository.save(modelMapper.map(seatAddDto, Seat.class));

    }

    @Override
    public SeatResponseDto deleteByid(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        if (seat.isPresent()) {
            SeatResponseDto map = modelMapper.map(seat.get(), SeatResponseDto.class);
            map.setFlightId(seat.get().getFlight().getId());
            this.seatRepository.delete(seat.get());
            return map;
        }
        return null;

    }

    @Override
    public List<SeatResponseDto> getAll() {
        List<Seat> seatList = this.seatRepository.findAll();
        List<SeatResponseDto> list = new ArrayList<>();
        for (Seat value : seatList) {
            SeatResponseDto map = modelMapper.map(value, SeatResponseDto.class);
            map.setFlightId(value.getFlight().getId());
            list.add(map);
        }
        return list;
    }

    @Override
    public SeatResponseDto getById(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        if (seat.isPresent()) {
            SeatResponseDto map = modelMapper.map(seat.get(), SeatResponseDto.class);
            map.setFlightId(seat.get().getFlight().getId());
            this.seatRepository.delete(seat.get());
            return map;
        }
        return null;
    }

    @Override
    public void updateById(SeatUpdateDto seatUpdateDto) {
        Seat seat = modelMapper.map(seatUpdateDto, Seat.class);
        this.seatRepository.save(seat);
    }

    @Override
    public List<SeatResponseDto> getAllByFlightId(Long flightId) {
        List<Seat> seatList = this.seatRepository.findAllByFlightId(flightId);
        List<SeatResponseDto> seatResponseDtos = new ArrayList<>();
        for (Seat seat : seatList
        ) {

            SeatResponseDto seatResponseDto = this.modelMapper.map(seat, SeatResponseDto.class);
            seatResponseDto.setFlightId(seat.getFlight().getId());
            seatResponseDtos.add(seatResponseDto);

        }
        return seatResponseDtos;
    }


}
