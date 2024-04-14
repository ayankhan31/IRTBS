package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class SeatAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatAvailabilityId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private LocalDate journeyStartDate;

    @ManyToOne
    @JoinColumn(name = "train_coach_id")
    private TrainCoach trainCoach;

    private Integer seatsAvailable;

	public Long getSeatAvailabilityId() {
		return seatAvailabilityId;
	}

	public void setSeatAvailabilityId(Long seatAvailabilityId) {
		this.seatAvailabilityId = seatAvailabilityId;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getJourneyStartDate() {
		return journeyStartDate;
	}

	public void setJourneyStartDate(LocalDate journeyStartDate) {
		this.journeyStartDate = journeyStartDate;
	}

	public TrainCoach getTrainCoach() {
		return trainCoach;
	}

	public void setTrainCoach(TrainCoach trainCoach) {
		this.trainCoach = trainCoach;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

    
}
