package com.example.AOP.CrossCuttingConcerns.Validators;

import com.example.AOP.Annotations.CompanyNameMustBeUnique;
import com.example.Repository.CompanyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyNameValidator implements ConstraintValidator<CompanyNameMustBeUnique, String> {
    private final CompanyRepository companyRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        long count = this.companyRepository.countByName(value);
        return count <= 0;
    }
}
