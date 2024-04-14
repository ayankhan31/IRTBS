package com.irtbs.trainsearch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irtbs.trainsearch.entities.TrainCoach;

@Repository
public interface TrainCoachRepository extends JpaRepository<TrainCoach, Integer>{
	
	@Query(value="SELECT * FROM traincoach\r\n"
			+ "WHERE train_id = ?1", nativeQuery=true)
	public List<TrainCoach> getCoach(int t_id);
}
