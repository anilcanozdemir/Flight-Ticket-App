package com.code16.AOP.CrossCuttingConcerns.Validators;

import com.code16.AOP.Annotations.CompanyNameMustBeUnique;
import com.code16.Repository.CompanyRepository;
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
