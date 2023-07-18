package com.example.Repository;

import com.example.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByFlight_FlightId(Long flightId);

    Optional<Seat> findByFlight_FlightIdAndSeatNumber(Long flightId, String seatNumber);

}