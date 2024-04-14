package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name="train")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Train {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int trainId;
	    private String trainName;
	    private int totalSeats;
	    private int totalCoaches;
	    private String days;
	    private String cateringServices;	
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "source_station_id")
	    private Station sourceStation;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "end_station_id")
	    private Station destinationStation;

	    
	    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private Set<Route> routes = new HashSet<>();

	    
	    

		public Train() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Train(int trainId, String trainName, int totalSeats, int totalCoaches, String days,
				String cateringServices, Station sourceStation, Station destinationStation, Set<Route> routes) {
			super();
			this.trainId = trainId;
			this.trainName = trainName;
			this.totalSeats = totalSeats;
			this.totalCoaches = totalCoaches;
			this.days = days;
			this.cateringServices = cateringServices;
			this.sourceStation = sourceStation;
			this.destinationStation = destinationStation;
			this.routes = routes;
		}


		public int getTrainId() {
			return trainId;
		}


		public void setTrainId(int trainId) {
			this.trainId = trainId;
		}


		public String getTrainName() {
			return trainName;
		}


		public void setTrainName(String trainName) {
			this.trainName = trainName;
		}


		public int getTotalSeats() {
			return totalSeats;
		}


		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}


		public int getTotalCoaches() {
			return totalCoaches;
		}


		public void setTotalCoaches(int totalCoaches) {
			this.totalCoaches = totalCoaches;
		}


		public String getDays() {
			return days;
		}


		public void setDays(String days) {
			this.days = days;
		}


		public String getCateringServices() {
			return cateringServices;
		}


		public void setCateringServices(String cateringServices) {
			this.cateringServices = cateringServices;
		}


		public Station getSourceStation() {
			return sourceStation;
		}


		public void setSourceStation(Station sourceStation) {
			this.sourceStation = sourceStation;
		}


		public Station getDestinationStation() {
			return destinationStation;
		}


		public void setDestinationStation(Station destinationStation) {
			this.destinationStation = destinationStation;
		}


		public Set<Route> getRoutes() {
			return routes;
		}


		public void setRoutes(Set<Route> routes) {
			this.routes = routes;
		}
	    
	  
	
	
     
}

