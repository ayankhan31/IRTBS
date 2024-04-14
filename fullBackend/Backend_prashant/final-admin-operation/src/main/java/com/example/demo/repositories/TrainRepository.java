package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.Train;


public interface TrainRepository extends JpaRepository<Train, Integer> {

}
