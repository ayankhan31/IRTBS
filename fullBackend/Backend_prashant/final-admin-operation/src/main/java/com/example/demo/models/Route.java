package com.example.demo.models;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "route")

public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeId;
    
    
//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", nullable = false)
    @JsonBackReference
    private Train train;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;
    
    @JsonIgnore
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<SeatAvailability> seatAvailabilities;

    private int stopNumber;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private int priceToNextStop;
    private int distanceToNextStop;

    // Constructors, Getters and Setters

    public Route() {
    }

	public Route(int routeId, Train train, Station station, List<SeatAvailability> seatAvailabilities, int stopNumber,
			LocalTime arrivalTime, LocalTime departureTime, int priceToNextStop, int distanceToNextStop) {
		super();
		this.routeId = routeId;
		this.train = train;
		this.station = station;
		this.seatAvailabilities = seatAvailabilities;
		this.stopNumber = stopNumber;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.priceToNextStop = priceToNextStop;
		this.distanceToNextStop = distanceToNextStop;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public List<SeatAvailability> getSeatAvailabilities() {
		return seatAvailabilities;
	}

	public void setSeatAvailabilities(List<SeatAvailability> seatAvailabilities) {
		this.seatAvailabilities = seatAvailabilities;
	}

	public int getStopNumber() {
		return stopNumber;
	}

	public void setStopNumber(int stopNumber) {
		this.stopNumber = stopNumber;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getPriceToNextStop() {
		return priceToNextStop;
	}

	public void setPriceToNextStop(int priceToNextStop) {
		this.priceToNextStop = priceToNextStop;
	}

	public int getDistanceToNextStop() {
		return distanceToNextStop;
	}

	public void setDistanceToNextStop(int distanceToNextStop) {
		this.distanceToNextStop = distanceToNextStop;
	}

    
}
