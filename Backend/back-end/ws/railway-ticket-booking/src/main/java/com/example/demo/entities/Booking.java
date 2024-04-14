package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status;

    @ManyToOne
    @JoinColumn(name = "boarding_station_id")
    private Station boardingStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    private Station destinationStation;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    private Integer pricePerTicket;
    private Integer numberOfPassengers;
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Station getBoardingStation() {
		return boardingStation;
	}
	public void setBoardingStation(Station boardingStation) {
		this.boardingStation = boardingStation;
	}
	public Station getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(Station destinationStation) {
		this.destinationStation = destinationStation;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Integer getPricePerTicket() {
		return pricePerTicket;
	}
	public void setPricePerTicket(Integer pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}
	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
    
}
