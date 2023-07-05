package com.example.Service.Concrete;

import com.example.DTOs.Company.Request.CompanyAddedDto;
import com.example.DTOs.Company.Request.CompanyUpdateDto;
import com.example.DTOs.Company.Response.CompanyResponseDto;
import com.example.Entity.Company;
import com.example.Repository.CompanyRepository;
import com.example.Service.Contrats.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class CompanyManager implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Override
    public void add(CompanyAddedDto companyAddedDto) {
        this.companyRepository.save(modelMapper.map(companyAddedDto, Company.class));

    }

    @Override
    public CompanyResponseDto deleteByid(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        company.ifPresent(companyRepository::delete);
        return company.map(value -> modelMapper.map(value, CompanyResponseDto.class)).orElse(null);
    }

    @Override
    public List<CompanyResponseDto> getAll() {
        List<Company> companyList = this.companyRepository.findAll();
        List<CompanyResponseDto> list = new ArrayList<>();
        for (Company value : companyList) {
            CompanyResponseDto map = modelMapper.map(value, CompanyResponseDto.class);
            list.add(map);
        }
        return list;
    }

    @Override
    public CompanyResponseDto getById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.map(value -> modelMapper.map(value, CompanyResponseDto.class)).orElse(null);
    }

    @Override
    public void updateById(CompanyUpdateDto companyUpdateDto) {
        Company company = modelMapper.map(companyUpdateDto, Company.class);
        this.companyRepository.save(company);

    }
}
