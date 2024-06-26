package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Route;
import com.example.demo.repositories.RouteRepository;
import com.example.demo.models.Train;
import com.example.demo.models.Station;
import com.example.demo.repositories.TrainRepository;
import com.example.demo.repositories.StationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/route")
public class RouteController {
    
    @Autowired
    private RouteRepository routeRepository;
    
    @Autowired
    private TrainRepository trainRepository;
    
    @Autowired
    private StationRepository stationRepository;
    
    @PostMapping("/create")
    public ResponseEntity<?> createRoute(@RequestBody Route route) {
        try {
        	   Station station = stationRepository.findById(route.getStation().getStationId())
                       .orElseThrow(() -> new IllegalArgumentException("Invalid station IDs"));
            // Retrieve Train entity using the provided trainId
            Train train = trainRepository.findById(route.getTrain().getTrainId())
                                         .orElseThrow(() -> new IllegalArgumentException("Invalid train ID"));
            
            // Retrieve Station entity using the provided stationId
         
            
            // Set the Train and Station entities in the Route entity
            route.setTrain(train);
            route.setStation(station);
            
            // Save the Route entity to the database
            routeRepository.save(route);
            
            // Return the saved Route entity in the response
            return ResponseEntity.ok("Route created successfully");
        } catch (IllegalArgumentException e) {
            // If invalid trainId or stationId provided, return a bad request response
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
