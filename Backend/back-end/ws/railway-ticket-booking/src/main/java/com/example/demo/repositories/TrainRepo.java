package com.example.demo.repositories;

import com.example.demo.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository<Train, Long> {
    // Define custom methods if needed
}
