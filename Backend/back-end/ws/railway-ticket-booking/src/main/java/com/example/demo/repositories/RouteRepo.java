package com.example.demo.repositories;

import com.example.demo.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route, Long> {
    // Define custom methods if needed
}
