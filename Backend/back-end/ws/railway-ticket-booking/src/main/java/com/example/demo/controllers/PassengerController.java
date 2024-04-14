package com.example.demo.controllers;

import com.example.demo.entities.Passenger;
import com.example.demo.repositories.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    private PassengerRepo passengerRepository;

}
