package com.example.demo.repositories;

import com.example.demo.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station, Long> {
    // Define custom methods if needed
}