package com.example.DTOs.Company.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyUpdateDto {
    private Long companyId;
    private String name;
}
