package com.example.demo.controllers;

import com.example.demo.entities.Coach;
import com.example.demo.repositories.CoachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {
    @Autowired
    private CoachRepo coachRepository;

}
