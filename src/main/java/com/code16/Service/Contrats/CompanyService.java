package com.code16.Service.Contrats;

import com.code16.DTOs.Company.Request.CompanyAddedDto;
import com.code16.DTOs.Company.Request.CompanyUpdateDto;
import com.code16.DTOs.Company.Response.CompanyResponseDto;

public interface CompanyService extends BaseService<CompanyResponseDto, CompanyAddedDto, CompanyUpdateDto> {
}
