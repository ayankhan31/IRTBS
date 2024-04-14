package com.example.demo.controllers;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminRepo adminRepository;

}
