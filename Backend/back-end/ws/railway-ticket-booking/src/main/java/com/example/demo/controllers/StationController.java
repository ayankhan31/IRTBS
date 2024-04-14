package com.example.demo.controllers;

import com.example.demo.entities.Station;
import com.example.demo.repositories.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationRepo stationRepository;

}
