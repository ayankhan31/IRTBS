package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seatavailability")
public class SeatAvailability {	
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatAvailabilityId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

  
    private LocalDate journeyStartDate;
    private int trainCoachId;
    private int seatsAvailable;
	public SeatAvailability(int seatAvailabilityId, Route route,
			LocalDate journeyStartDate, int trainCoachId, int seatAvailable) {
		super();
		this.seatAvailabilityId = seatAvailabilityId;
		this.route = route;
		
		this.journeyStartDate = journeyStartDate;
		this.trainCoachId = trainCoachId;
		this.seatsAvailable = seatAvailable;
	}
	public int getSeatAvailabilityId() {
		return seatAvailabilityId;
	}
	public void setSeatAvailabilityId(int seatAvailabilityId) {
		this.seatAvailabilityId = seatAvailabilityId;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}

	public LocalDate getJourneyStartDate() {
		return journeyStartDate;
	}
	public void setJourneyStartDate(LocalDate journeyStartDate) {
		this.journeyStartDate = journeyStartDate;
	}
	public int getTrainCoachId() {
		return trainCoachId;
	}
	public void setTrainCoachId(int trainCoachId) {
		this.trainCoachId = trainCoachId;
	}
	public int getSeatAvailable() {
		return seatsAvailable;
	}
	public void setSeatAvailable(int seatAvailable) {
		this.seatsAvailable = seatAvailable;
	}

    // Getters and setters
    
    
}

