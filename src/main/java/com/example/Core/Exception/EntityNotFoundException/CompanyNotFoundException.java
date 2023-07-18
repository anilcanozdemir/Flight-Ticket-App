package com.example.Core.Exception.EntityNotFoundException;

public class CompanyNotFoundException extends EntityNotFoundException {

    public CompanyNotFoundException(String companyName) {
        super("companyName  :" + companyName + " is not found.");
    }

    public CompanyNotFoundException(Long id) {
        super("companyId  :" + id + " is not found.");
    }
}
