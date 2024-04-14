package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class TrainCoach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainCoachId;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    private Integer noOfCoach;

	public Long getTrainCoachId() {
		return trainCoachId;
	}

	public void setTrainCoachId(Long trainCoachId) {
		this.trainCoachId = trainCoachId;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Integer getNoOfCoach() {
		return noOfCoach;
	}

	public void setNoOfCoach(Integer noOfCoach) {
		this.noOfCoach = noOfCoach;
	}
    
}
