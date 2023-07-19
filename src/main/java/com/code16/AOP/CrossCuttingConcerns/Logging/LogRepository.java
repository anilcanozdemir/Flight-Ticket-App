package com.code16.AOP.CrossCuttingConcerns.Logging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogParameters, Long> {
}
