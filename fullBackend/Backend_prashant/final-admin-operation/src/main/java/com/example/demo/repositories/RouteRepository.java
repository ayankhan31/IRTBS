package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {

}
