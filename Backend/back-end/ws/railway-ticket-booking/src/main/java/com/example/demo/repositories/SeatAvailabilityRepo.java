package com.example.demo.repositories;

import com.example.demo.entities.SeatAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatAvailabilityRepo extends JpaRepository<SeatAvailability, Long> {
    // Define custom methods if needed
}
