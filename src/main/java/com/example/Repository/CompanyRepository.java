package com.example.Repository;

import com.example.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    long countByName(String name);

    Optional<Company> findByName(String name);
}