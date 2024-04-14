package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Long>{

}
