package com.example.demo.entities;

import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    private Integer stopNumber;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private Integer priceToNextStop;
    private Integer distanceToNextStop;
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
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
	public Integer getStopNumber() {
		return stopNumber;
	}
	public void setStopNumber(Integer stopNumber) {
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
	public Integer getPriceToNextStop() {
		return priceToNextStop;
	}
	public void setPriceToNextStop(Integer priceToNextStop) {
		this.priceToNextStop = priceToNextStop;
	}
	public Integer getDistanceToNextStop() {
		return distanceToNextStop;
	}
	public void setDistanceToNextStop(Integer distanceToNextStop) {
		this.distanceToNextStop = distanceToNextStop;
	}
    
}
