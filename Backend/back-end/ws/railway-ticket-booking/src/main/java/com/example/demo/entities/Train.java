package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    private String trainName;

    @ManyToOne
    @JoinColumn(name = "source_station_id")
    private Station sourceStation;

    @ManyToOne
    @JoinColumn(name = "end_station_id")
    private Station endStation;

    private Integer totalSeats;
    private Integer totalCoaches;
    private Integer days;
    private String cateringService;
	public Long getTrainId() {
		return trainId;
	}
	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public Station getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(Station sourceStation) {
		this.sourceStation = sourceStation;
	}
	public Station getEndStation() {
		return endStation;
	}
	public void setEndStation(Station endStation) {
		this.endStation = endStation;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Integer getTotalCoaches() {
		return totalCoaches;
	}
	public void setTotalCoaches(Integer totalCoaches) {
		this.totalCoaches = totalCoaches;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getCateringService() {
		return cateringService;
	}
	public void setCateringService(String cateringService) {
		this.cateringService = cateringService;
	}

    
}
