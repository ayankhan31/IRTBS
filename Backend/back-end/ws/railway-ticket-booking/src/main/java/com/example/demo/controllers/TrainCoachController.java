package com.example.demo.controllers;

import com.example.demo.entities.TrainCoach;
import com.example.demo.repositories.TrainCoachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traincoaches")
public class TrainCoachController {
    @Autowired
    private TrainCoachRepo trainCoachRepository;
}
