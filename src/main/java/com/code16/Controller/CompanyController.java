package com.code16.Controller;


import com.code16.Core.Result.DataResult;
import com.code16.Core.Result.Result;
import com.code16.DTOs.Company.Request.CompanyAddedDto;
import com.code16.DTOs.Company.Request.CompanyUpdateDto;
import com.code16.DTOs.Company.Response.CompanyResponseDto;
import com.code16.Service.Contrats.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CompanyAddedDto companyAddedDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.companyService.add(companyAddedDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<CompanyResponseDto>>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(this.companyService.getAll());

    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<CompanyResponseDto>> getById(@RequestParam Long companyId) {

        return ResponseEntity.status(HttpStatus.OK).body(this.companyService.getById(companyId));

    }

    @PostMapping("/updateById")
    public ResponseEntity<Result> updateById(@Valid @RequestBody CompanyUpdateDto companyUpdateDto) {

        return ResponseEntity.status(HttpStatus.OK).body(this.companyService.updateById(companyUpdateDto));

    }

    @PostMapping("/deleteById")
    public ResponseEntity<DataResult<CompanyResponseDto>> deleteById(@RequestParam Long companyId) {

        return ResponseEntity.status(HttpStatus.OK).body(this.companyService.deleteByid(companyId));
    }

}
