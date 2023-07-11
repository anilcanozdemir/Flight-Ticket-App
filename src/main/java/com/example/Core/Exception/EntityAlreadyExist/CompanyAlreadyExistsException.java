package com.example.Core.Exception.EntityAlreadyExist;

public class CompanyAlreadyExistsException extends EntityAlreadyExistsException {
    public CompanyAlreadyExistsException(String companyName) {
        super("companyName  :" + companyName + " already exist in CompanyRepository.");
    }
}
