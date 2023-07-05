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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Seat> seatList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId")
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private FlyType flyType;

}
