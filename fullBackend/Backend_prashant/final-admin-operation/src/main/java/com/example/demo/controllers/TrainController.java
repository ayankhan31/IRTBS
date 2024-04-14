package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.Train;
import com.example.demo.repositories.TrainRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/train")
public class TrainController {

    @Autowired
    private TrainRepository trainRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addTrain(@RequestBody Train train) {
        trainRepository.save(train);
        return new ResponseEntity<>("Train added successfully", HttpStatus.OK);
    }
    @GetMapping("/getRecord")
	public List<Train> getStation(){
		return trainRepository.findAll();
	}

}
