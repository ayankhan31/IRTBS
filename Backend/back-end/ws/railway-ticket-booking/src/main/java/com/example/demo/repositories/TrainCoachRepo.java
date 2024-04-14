package com.example.demo.repositories;

import com.example.demo.entities.TrainCoach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainCoachRepo extends JpaRepository<TrainCoach, Long> {
    // Define custom methods if needed
}
