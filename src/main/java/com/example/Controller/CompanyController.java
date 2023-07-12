package com.example.Controller;


import com.example.Core.Result.DataResult;
import com.example.Core.Result.ErrorResult;
import com.example.Core.Result.Result;
import com.example.DTOs.Company.Request.CompanyAddedDto;
import com.example.DTOs.Company.Request.CompanyUpdateDto;
import com.example.DTOs.Company.Response.CompanyResponseDto;
import com.example.Service.Contrats.Service.CompanyService;
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
    public ResponseEntity<Result> add(@RequestBody CompanyAddedDto companyAddedDto) {
       return ResponseEntity.status(HttpStatus.CREATED).body( this.companyService.add(companyAddedDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<CompanyResponseDto>>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body( this.companyService.getAll());

    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<CompanyResponseDto>> getById(@RequestParam Long companyId) {

        return ResponseEntity.status(HttpStatus.OK).body( this.companyService.getById(companyId));

    }

    @PostMapping("/updateById")
    public ResponseEntity<Result> updateById(@RequestBody CompanyUpdateDto companyUpdateDto) {

        return ResponseEntity.status(HttpStatus.OK).body(  this.companyService.updateById(companyUpdateDto));

    }

    @PostMapping("/deleteById")
    public ResponseEntity<DataResult<CompanyResponseDto>> deleteById(@RequestParam Long companyId) {

        return ResponseEntity.status(HttpStatus.OK).body( this.companyService.deleteByid(companyId));
    }

}
