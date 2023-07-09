package com.example.Service.Concrete;

import com.example.DTOs.Flight.Request.FlightAddedDto;
import com.example.DTOs.Flight.Request.FlightUpdateDto;
import com.example.DTOs.Flight.Response.FlightResponseDto;
import com.example.Entity.Company;
import com.example.Entity.Flight;
import com.example.Repository.FlightRepository;
import com.example.Service.Contrats.CompanyService;
import com.example.Service.Contrats.FlightService;
import com.example.Service.Contrats.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                         @Lazy  CompanyService companyService,
                         ModelMapper modelMapper )
    {
        this.flightRepository=flightRepository;
        this.seatService=seatService;
        this.companyService=companyService;
        this.modelMapper=modelMapper;
    }
    @Override
    public void add(FlightAddedDto flightAddedDto) {
       

        Flight flight=extracted(flightAddedDto);
        flight= this.flightRepository.save(flight);
        this.seatService.add(flight.getId(), flight.getCapacity());


    }
    private Flight extracted(FlightAddedDto flightAddedDto) {
        Flight flight=new Flight();
        flight.setCompany( modelMapper.map(this.companyService.getById(flightAddedDto.getCompanyId()), Company.class));
        flight.setPrice(flightAddedDto.getPrice());
        flight.setCapacity(flightAddedDto.getCapacity());
        flight.setFlyType(flightAddedDto.getFlyType());
        flight.setBusinessCapacity(flight.getBusinessCapacity());
        flight.setBusinessExtra(flight.getBusinessExtra());
        return flight;
    }
    @Override
    public FlightResponseDto deleteByid(Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isPresent())
        {
            FlightResponseDto map=  modelMapper.map(flight.get(), FlightResponseDto.class);
            map.setCompanyId(flight.get().getCompany().getId());
            this.flightRepository.delete(flight.get());
            return map;
        }
        return null;

    }

    @Override
    public List<FlightResponseDto> getAll() {
        List<Flight> flightList = this.flightRepository.findAll();
        List<FlightResponseDto> list = new ArrayList<>();
        for (Flight value : flightList) {
            FlightResponseDto map = modelMapper.map(value, FlightResponseDto.class);
            map.setCompanyId(value.getCompany().getId());
            //map.setSeatList(this.seatService.getAllByFlightId(map.getId()));
            list.add(map);
        }
        return list;
    }

    @Override
    public FlightResponseDto getById(Long id) {
        Optional<Flight> flight = this.flightRepository.findById(id);

        if(flight.isPresent())
        {
            FlightResponseDto map=  modelMapper.map(flight.get(), FlightResponseDto.class);
            map.setCompanyId(flight.get().getCompany().getId());
            return map;
        }
       return null;

    }

    @Override
    public void updateById(FlightUpdateDto flightUpdateDto) {
        Flight flight = modelMapper.map(flightUpdateDto, Flight.class);
        this.flightRepository.save(flight);

    }
}
