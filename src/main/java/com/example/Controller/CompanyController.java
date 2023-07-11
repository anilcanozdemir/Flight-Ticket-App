package com.example.Controller;


import com.example.Core.Result.DataResult;
import com.example.Core.Result.Result;
import com.example.DTOs.Company.Request.CompanyAddedDto;
import com.example.DTOs.Company.Request.CompanyUpdateDto;
import com.example.DTOs.Company.Response.CompanyResponseDto;
import com.example.Service.Contrats.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/add")
    public void add(@RequestBody CompanyAddedDto companyAddedDto) {
        this.companyService.add(companyAddedDto);
    }

    @GetMapping("/getAll")
    public DataResult<List<CompanyResponseDto>> getAll() {
        return this.companyService.getAll();

    }

    @GetMapping("/getById")
    public DataResult<CompanyResponseDto> getById(@RequestParam Long companyId) {
        return this.companyService.getById(companyId);

    }

    @PostMapping("/updateById")
    public Result updateById(@RequestBody CompanyUpdateDto companyUpdateDto) {
        return this.companyService.updateById(companyUpdateDto);

    }

    @PostMapping("/deleteById")
    public DataResult<CompanyResponseDto> deleteById(@RequestParam Long companyId) {
        return this.companyService.deleteByid(companyId);
    }

}
