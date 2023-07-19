package com.code16.Entity;

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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    @OneToMany(mappedBy = "company")
    private List<Flight> flightList;
    @Column
    private String name;


}