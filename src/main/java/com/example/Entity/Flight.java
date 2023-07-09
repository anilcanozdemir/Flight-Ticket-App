package com.example.Entity;


import com.example.Enums.FlyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "flight")
@Getter
@Setter

public class Flight {
    @Column
    private int capacity;
    @OneToMany(mappedBy = "flight")
    private List<Seat> seatList;
    @ManyToOne()
    @JoinColumn(name = "companyId")
    private Company company;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private FlyType flyType;
    @Column
    private double price;
    @Column
    private double businessExtra;
    @Column
    private int businessCapacity;

}
