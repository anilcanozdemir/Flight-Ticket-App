package com.example.Repository;

import com.example.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByFlightId(Long flightId);

    Seat findByFlightIdAndSeatNumber(Long flightId, String seatNumber);
}