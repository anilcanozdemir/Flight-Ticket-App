package com.code16.Repository;

import com.code16.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    long countByName(String name);

    Optional<Company> findByName(String name);
}