package com.code16.Service.Concrete;

import com.code16.AOP.Annotations.Logging.LoggerToDbForResult;
import com.code16.Core.Exception.EntityAlreadyExist.CompanyAlreadyExistsException;
import com.code16.Core.Exception.EntityListEmptyException.CompanyListEmptyException;
import com.code16.Core.Exception.EntityNotFoundException.CompanyNotFoundException;
import com.code16.Core.Result.DataResult;
import com.code16.Core.Result.Result;
import com.code16.Core.Result.SuccessDataResult;
import com.code16.Core.Result.SuccessResult;
import com.code16.DTOs.Company.Request.CompanyAddedDto;
import com.code16.DTOs.Company.Request.CompanyUpdateDto;
import com.code16.DTOs.Company.Response.CompanyResponseDto;
import com.code16.Entity.Company;
import com.code16.Repository.CompanyRepository;
import com.code16.Service.Contrats.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class CompanyManager implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Override
    @LoggerToDbForResult
    public Result add(CompanyAddedDto companyAddedDto) {
        Optional<Company> company = companyRepository.findByName(companyAddedDto.getName());
        if (company.isPresent()) {
            throw new CompanyAlreadyExistsException(companyAddedDto.getName());
        }

        this.companyRepository.save(modelMapper.map(companyAddedDto, Company.class));
        return new SuccessResult(companyAddedDto.getName() + " firması başarıyla kaydedildi.");


    }

    @Override
    @LoggerToDbForResult
    public DataResult<CompanyResponseDto> deleteByid(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isEmpty()) {
            throw new CompanyNotFoundException(id);
        }
        company.ifPresent(companyRepository::delete);
        return new SuccessDataResult<>("Company with id  " + id + "  deleted successfully.",

                company.map(value -> modelMapper.map(value, CompanyResponseDto.class)).orElseThrow(() -> new CompanyNotFoundException(id)));

    }

    @Override
    @LoggerToDbForResult
    public DataResult<List<CompanyResponseDto>> getAll() {
        List<Company> companyList = this.companyRepository.findAll();
        if (companyList.isEmpty()) {
            throw new CompanyListEmptyException();
        }
        return new SuccessDataResult<>("CompanyList successfully called.", companyList.stream().map(x -> modelMapper.map(x, CompanyResponseDto.class)).toList());

    }

    @Override
    @LoggerToDbForResult
    public DataResult<CompanyResponseDto> getById(Long id) {

        Optional<Company> company = this.companyRepository.findById(id);
        return new SuccessDataResult<>("Company with id " + id + "successfully called.", company.map(value -> modelMapper.map(value, CompanyResponseDto.class)).orElseThrow(() -> new CompanyNotFoundException(id)));
    }

    @Override
    @LoggerToDbForResult
    public Result updateById(CompanyUpdateDto companyUpdateDto) {
        Optional<Company> companyOld = this.companyRepository.findById(companyUpdateDto.getCompanyId());
        if (companyOld.isPresent()) {
            if (!(companyOld.get().getName().equals(companyUpdateDto.getName()))) {
                Optional<Company> company = companyRepository.findByName(companyUpdateDto.getName());
                company.ifPresent(x -> {
                    throw new CompanyAlreadyExistsException(x.getName());
                });
            }
            this.companyRepository.save(this.modelMapper.map(companyUpdateDto, Company.class));
            return new SuccessResult(companyUpdateDto.getName());
        }
        throw new CompanyNotFoundException(companyUpdateDto.getName());


    }
}
