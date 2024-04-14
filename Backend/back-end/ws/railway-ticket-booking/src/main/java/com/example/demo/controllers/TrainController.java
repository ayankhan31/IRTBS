package com.example.demo.controllers;

import com.example.demo.entities.Train;
import com.example.demo.repositories.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    private TrainRepo trainRepository;

}
