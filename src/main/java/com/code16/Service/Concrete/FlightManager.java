package com.code16.Service.Concrete;

import com.code16.AOP.Annotations.Logging.LoggerToDbForResult;
import com.code16.Constants.BusinessConstants;
import com.code16.Core.Exception.EntityListEmptyException.FlightListEmptyException;
import com.code16.Core.Exception.EntityNotFoundException.FlightNotFoundException;
import com.code16.Core.Exception.FlightNonAcceptableCapacityException;
import com.code16.Core.Result.DataResult;
import com.code16.Core.Result.Result;
import com.code16.Core.Result.SuccessDataResult;
import com.code16.Core.Result.SuccessResult;
import com.code16.DTOs.Flight.Request.FlightAddedDto;
import com.code16.DTOs.Flight.Request.FlightUpdateDto;
import com.code16.DTOs.Flight.Response.FlightResponseDto;
import com.code16.Entity.Company;
import com.code16.Entity.Flight;
import com.code16.Repository.FlightRepository;
import com.code16.Service.Contrats.CompanyService;
import com.code16.Service.Contrats.FlightService;
import com.code16.Service.Contrats.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class FlightManager implements FlightService {
    private final FlightRepository flightRepository;

    private final SeatService seatService;

    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    public FlightManager(FlightRepository flightRepository,
                         @Lazy SeatService seatService,
                         @Lazy CompanyService companyService,
                         ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.seatService = seatService;
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @Override
    @LoggerToDbForResult
    public Result add(FlightAddedDto flightAddedDto) {


        Flight flight = DtoToFlight(flightAddedDto);
        if (flight.getCapacity() % BusinessConstants.SEATS_PER_ROW != 0) {
            throw new FlightNonAcceptableCapacityException(flight.getCapacity());
        }
        flight = this.flightRepository.save(flight);

        this.seatService.add(flight.getFlightId(), flight.getCapacity());
        return new SuccessResult("Flight created with the id " + flight.getFlightId());

    }

    private Flight DtoToFlight(FlightAddedDto flightAddedDto) {
        Flight flight = new Flight();

        flight.setCompany(modelMapper.map(this.companyService.getById(flightAddedDto.getCompanyId()).getData(), Company.class));
        flight.setPrice(flightAddedDto.getPrice());
        flight.setCapacity(flightAddedDto.getCapacity());
        flight.setFlyType(flightAddedDto.getFlyType());
        flight.setBusinessCapacity(flightAddedDto.getBusinessCapacity());
        flight.setBusinessExtra(flightAddedDto.getBusinessExtra());
        return flight;
    }

    @Override
    @LoggerToDbForResult
    public DataResult<FlightResponseDto> deleteByid(Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()) {
            FlightResponseDto map = modelMapper.map(flight.get(), FlightResponseDto.class);
            map.setCompanyId(flight.get().getCompany().getCompanyId());
            this.flightRepository.delete(flight.get());
            return new SuccessDataResult<>("Flight with id" + id + "is deleted successfully.", map);
        }
        throw new FlightNotFoundException(id);

    }

    @Override
    @LoggerToDbForResult
    public DataResult<List<FlightResponseDto>> getAll() {
        List<Flight> flightList = this.flightRepository.findAll();
        if (flightList.isEmpty())
            throw new FlightListEmptyException();
        return new SuccessDataResult<>(
                "Flightlist is successfully called.",
                flightList.stream().map(flight -> {
                            FlightResponseDto map = modelMapper.map(flight, FlightResponseDto.class);
                            map.setCompanyId(flight.getCompany().getCompanyId());
                            return map;
                        }
                ).toList());

    }

    @Override
    @LoggerToDbForResult
    public DataResult<FlightResponseDto> getById(Long id) {
        Optional<Flight> flight = this.flightRepository.findById(id);

        if (flight.isPresent()) {
            FlightResponseDto map = modelMapper.map(flight.get(), FlightResponseDto.class);
            map.setCompanyId(flight.get().getCompany().getCompanyId());
            return new SuccessDataResult<>(
                    "Flight with id" + id + "is successfully called",
                    map);
        }
        throw new FlightNotFoundException(id);

    }

    @Override
    @LoggerToDbForResult
    public Result updateById(FlightUpdateDto flightUpdateDto) {
        Optional<Flight> flightOld = this.flightRepository.findById(flightUpdateDto.getFlightId());
        if (flightOld.isEmpty()) {
            throw new FlightNotFoundException(flightUpdateDto.getFlightId());
        }
        Flight flight = modelMapper.map(flightUpdateDto, Flight.class);
        this.flightRepository.save(flight);
        return new SuccessResult("Successfully updated flight by id" + flight.getFlightId());
    }
}
