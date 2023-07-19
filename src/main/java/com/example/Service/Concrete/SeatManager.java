package com.example.Service.Concrete;


import com.example.AOP.Annotations.Logging.LoggerToDbForResult;
import com.example.Constants.BusinessConstants;
import com.example.Core.Exception.EntityAlreadyExist.SeatAlreadyExistException;
import com.example.Core.Exception.EntityListEmptyException.SeatListEmptyException;
import com.example.Core.Exception.EntityNotFoundException.SeatNotFoundException;
import com.example.Core.Exception.SeatIdListEmptyException;
import com.example.Core.Result.DataResult;
import com.example.Core.Result.Result;
import com.example.Core.Result.SuccessDataResult;
import com.example.Core.Result.SuccessResult;
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
    @LoggerToDbForResult
    public Result add(Long id, int capacity) {
        String[] seatNumbers = SeatNumber.generateSeatNumbers(capacity / BusinessConstants.SEATS_PER_ROW, BusinessConstants.SEATS_PER_ROW);

        for (int i = 0; i < capacity; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber(seatNumbers[i]);
            if (i < this.flightService.getById(id).getData().getBusinessCapacity()) {
                seat.setSeatType(SeatType.BUSINESS);
            } else {
                seat.setSeatType(SeatType.ECONOMY);
            }
            seat.setFullled(false);
            seat.setFlight(modelMapper.map(this.flightService.getById(id).getData(), Flight.class));

            this.seatRepository.save(seat);
        }
        return new SuccessResult("Seats for Flight with id" + id + "and capacity" + capacity + " are created.");
    }

    @Override
    @LoggerToDbForResult
    public DataResult<Double> getPriceById(Long id) {
        Optional<Seat> seat = this.seatRepository.findById(id);

        if (seat.isPresent()) {
            Double price = seat.get().getFlight().getPrice();
            if (seat.get().getSeatType() == SeatType.BUSINESS)
                price += seat.get().getFlight().getBusinessExtra();
            return new SuccessDataResult<>("", price);
        }
        throw new SeatNotFoundException(id);
    }

    @Override
    @LoggerToDbForResult
    public DataResult<Double> getPriceByIdList(List<Long> idList) {
        Double price = 0.0;
        if (idList.isEmpty()) {
            throw new SeatIdListEmptyException();
        }

        for (Long id :
                idList) {
            Optional<Seat> seat = this.seatRepository.findById(id);
            if (seat.isEmpty()) {
                throw new SeatNotFoundException(id);
            }

            price += seat.get().getFlight().getPrice();
            if (seat.get().getSeatType() == SeatType.BUSINESS)
                price += seat.get().getFlight().getBusinessExtra();


        }
        return new SuccessDataResult<>(price);

    }

    @Override
    @LoggerToDbForResult
    public DataResult<Double> buyById(Long id) {
        Optional<Seat> seat = this.seatRepository.findById(id);
        if (seat.isEmpty()) {
            throw new SeatNotFoundException(id);
        }

        Double price = seat.get().getFlight().getPrice();
        if (seat.get().getSeatType() == SeatType.BUSINESS)
            price += seat.get().getFlight().getBusinessExtra();
        seat.get().setFullled(true);
        this.seatRepository.save(seat.get());
        return new SuccessDataResult<>(price);


    }

    @Override
    @LoggerToDbForResult
    public DataResult<Double> buyByIdList(List<Long> idList) {
        Double price = 0.0;
        if (idList.isEmpty()) {
            throw new SeatIdListEmptyException();
        }

        for (Long id :
                idList) {
            Optional<Seat> seat = this.seatRepository.findById(id);
            if (seat.isEmpty()) {
                throw new SeatNotFoundException(id);
            }

            price += seat.get().getFlight().getPrice();
            if (seat.get().getSeatType() == SeatType.BUSINESS)
                price += seat.get().getFlight().getBusinessExtra();
            seat.get().setFullled(true);
            this.seatRepository.save(seat.get());

        }
        return new SuccessDataResult<>(price);
    }

    @Override
    @LoggerToDbForResult
    public DataResult<SeatResponseDto> getByFlightIdAndSeatNumber(String seatNumber, Long flightId) {
        Optional<Seat> seat = seatRepository.findByFlight_FlightIdAndSeatNumber(flightId, seatNumber);
        if (seat.isEmpty())
            throw new SeatNotFoundException(seatNumber, flightId);
        return new SuccessDataResult<>(modelMapper.map(seat.get(), SeatResponseDto.class));
    }

    @Override
    @LoggerToDbForResult
    public Result add(SeatAddDto seatAddDto) {
        Optional<Seat> optional = seatRepository.findByFlight_FlightIdAndSeatNumber(seatAddDto.getFlightId(), seatAddDto.getSeatNumber());
        if (optional.isPresent()) {
            throw new SeatAlreadyExistException(seatAddDto.getFlightId(), seatAddDto.getSeatNumber());
        }
        Seat seat = this.seatRepository.save(modelMapper.map(seatAddDto, Seat.class));
        return new SuccessResult("Seat  " + seat.getSeatId() + "     başarıyla Eklendi.");
    }

    @Override
    @LoggerToDbForResult
    public DataResult<SeatResponseDto> deleteByid(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        if (seat.isEmpty()) {
            throw new SeatNotFoundException(id);
        }

        SeatResponseDto map = modelMapper.map(seat.get(), SeatResponseDto.class);
        map.setFlightId(seat.get().getFlight().getFlightId());
        this.seatRepository.delete(seat.get());
        return new SuccessDataResult<>(map);


    }

    @Override
    @LoggerToDbForResult
    public DataResult<List<SeatResponseDto>> getAll() {
        List<Seat> seatList = this.seatRepository.findAll();
        if (seatList.isEmpty())
            throw new SeatListEmptyException();

        return new SuccessDataResult<>(
                "SeatList is successfully called.",
                seatList.stream().map(value ->
                {
                    SeatResponseDto map = modelMapper.map(value, SeatResponseDto.class);
                    map.setFlightId(value.getFlight().getFlightId());
                    return map;
                }).toList());

    }

    @Override
    @LoggerToDbForResult
    public DataResult<SeatResponseDto> getById(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        if (seat.isEmpty()) {
            throw new SeatNotFoundException(id);
        }
        SeatResponseDto map = modelMapper.map(seat.get(), SeatResponseDto.class);
        map.setFlightId(seat.get().getFlight().getFlightId());
        this.seatRepository.delete(seat.get());
        return new SuccessDataResult<>(map);
    }

    @Override
    @LoggerToDbForResult
    public Result updateById(SeatUpdateDto seatUpdateDto) {
        Optional<Seat> seat = this.seatRepository.findById(seatUpdateDto.getSeatId());
        if (seat.isEmpty()) {
            throw new SeatNotFoundException(seatUpdateDto.getSeatId());
        }
        this.seatRepository.save(modelMapper.map(seatUpdateDto, Seat.class));
        return new SuccessResult("Seat with id  " + seatUpdateDto.getSeatId() + "updated succesfully.");
    }

    @Override
    @LoggerToDbForResult
    public DataResult<List<SeatResponseDto>> getAllByFlightId(Long flightId) {
        List<Seat> seatList = seatRepository.findByFlight_FlightId(flightId);
        if (seatList.isEmpty()) {
            throw new SeatListEmptyException(flightId);
        }

        return new SuccessDataResult<>(seatList.stream().map(seat -> {
            SeatResponseDto seatResponseDto = this.modelMapper.map(seat, SeatResponseDto.class);
            seatResponseDto.setFlightId(seat.getFlight().getFlightId());
            return seatResponseDto;
        }).toList());

    }


}
