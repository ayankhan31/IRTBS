package com.example.demo.controllers;

import com.example.demo.entities.SeatAvailability;
import com.example.demo.repositories.SeatAvailabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seatavailabilities")
public class SeatAvailabilityController {
    @Autowired
    private SeatAvailabilityRepo seatAvailabilityRepository;

    @GetMapping
    public List<SeatAvailability> getAllSeatAvailabilities() {
        return seatAvailabilityRepository.findAll();
    }

    @GetMapping("/{id}")
    public SeatAvailability getSeatAvailabilityById(@PathVariable Long id) {
        return seatAvailabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SeatAvailability not found with id: " + id));
    }

    @PostMapping
    public SeatAvailability createSeatAvailability(@RequestBody SeatAvailability seatAvailability) {
        return seatAvailabilityRepository.save(seatAvailability);
    }

    @PutMapping("/{id}")
    public SeatAvailability updateSeatAvailability(@PathVariable Long id, @RequestBody SeatAvailability updatedSeatAvailability) {
        return seatAvailabilityRepository.findById(id)
                .map(seatAvailability -> {
                    seatAvailability.setRoute(updatedSeatAvailability.getRoute());
                    seatAvailability.setArrivalDate(updatedSeatAvailability.getArrivalDate());
                    seatAvailability.setDepartureDate(updatedSeatAvailability.getDepartureDate());
                    seatAvailability.setJourneyStartDate(updatedSeatAvailability.getJourneyStartDate());
                    seatAvailability.setTrainCoach(updatedSeatAvailability.getTrainCoach());
                    seatAvailability.setSeatsAvailable(updatedSeatAvailability.getSeatsAvailable());
                    return seatAvailabilityRepository.save(seatAvailability);
                })
                .orElseThrow(() -> new RuntimeException("SeatAvailability not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteSeatAvailability(@PathVariable Long id) {
        seatAvailabilityRepository.deleteById(id);
    }
}
