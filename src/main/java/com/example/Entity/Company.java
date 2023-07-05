package com.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "companyId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Flight> flightList;
    private String name;


}