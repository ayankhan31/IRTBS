package com.example.demo.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="station")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Station {
	
	
	@Id
	private int stationId;
	private String stationName;
	private String state;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sourceStation")
    private List<Train> sourceTrains;

	@JsonIgnore
    @OneToMany(mappedBy = "destinationStation")
    private List<Train> destinationTrains;
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "station", fetch = FetchType.LAZY)
	    private Set<Route> routes = new HashSet<>();
	    
	    // Getter and Setter for routes
	    public Set<Route> getRoutes() {
	        return routes;
	    }

	    public void setRoutes(Set<Route> routes) {
	        this.routes = routes;
	    }
	
	
	public Station(int stationId, String stationName, String state, List<Train> sourceTrains,
				List<Train> destinationTrains, Set<Route> routes) {
			super();
			this.stationId = stationId;
			this.stationName = stationName;
			this.state = state;
			this.sourceTrains = sourceTrains;
			this.destinationTrains = destinationTrains;
			this.routes = routes;
		}

	

	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Train> getSourceTrains() {
		return sourceTrains;
	}
	public void setSourceTrains(List<Train> sourceTrains) {
		this.sourceTrains = sourceTrains;
	}
	public List<Train> getDestinationTrains() {
		return destinationTrains;
	}
	public void setDestinationTrains(List<Train> destinationTrains) {
		this.destinationTrains = destinationTrains;
	}
	
	
	
	

}
