package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Coach;

@Repository
public interface CoachRepo extends JpaRepository<Coach, Long> {

}
