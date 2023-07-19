package com.example.DTOs.Company.Request;

import com.example.AOP.Annotations.CompanyNameMustBeUnique;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyUpdateDto {
    @NotNull(message = "companyId can not be empty.")
    @NotBlank(message = "companyId can not be blank.")
    private Long companyId;
    @NotNull(message = "CompanyName can not be empty")
    @NotBlank(message = "CompanyName can not be blank.")
    @CompanyNameMustBeUnique
    private String name;
}
