package com.example.Controller;


import com.example.DTOs.Company.Request.CompanyAddedDto;
import com.example.DTOs.Company.Request.CompanyUpdateDto;
import com.example.DTOs.Company.Response.CompanyResponseDto;
import com.example.Service.Contrats.CompanyService;
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
    public List<CompanyResponseDto> getAll() {
        return this.companyService.getAll();

    }

    @GetMapping("/getById")
    public CompanyResponseDto getById(@RequestParam Long companyId) {
        return this.companyService.getById(companyId);

    }

    @PostMapping("/updateById")
    public void updateById(@RequestBody CompanyUpdateDto companyUpdateDto) {
        this.companyService.updateById(companyUpdateDto);

    }

    @PostMapping("/deleteById")
    public CompanyResponseDto deleteById(@RequestParam Long companyId) {
        return this.companyService.deleteByid(companyId);
    }

}
