package com.code16.AOP.CrossCuttingConcerns.Logging;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class LogParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private long id;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "parameters")
    private String parameters;

    @Column(name = "log_date")
    private Date logDate;

    @Column(name = "returnValue")
    private String returnValue;

    @Column(name = "log_status")
    @Enumerated(EnumType.STRING)
    private LogStatus logStatus;

}
