package com.example.Entity;

import com.example.Enums.SeatNumber;
import com.example.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;
    @Column
    private String seatNumber;
    @Column
    private boolean fullled;

    @Enumerated(EnumType.STRING)
    @Column
    private SeatType seatType;

}