package com.example.demo.controllers;

import com.example.demo.entities.Route;
import com.example.demo.repositories.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteRepo routeRepository;

}
