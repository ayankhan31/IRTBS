package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AdminDTO;
import com.example.demo.models.LoginDTO;
import com.example.demo.models.LoginMesage;
import com.example.demo.services.AdminService;


@RestController
@RequestMapping("admin/")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AdminRestController {
	
	
	

	
	@Autowired
	private AdminService adminService;
	
	 @PostMapping(path = "/save")
	    public String saveEmployee(@RequestBody AdminDTO admindto)
	    {
	        String id =adminService.addAdmin(admindto);
	        return id;
	    }
	 
	    @PostMapping(path = "/login")
	    public ResponseEntity<?> loginAdmin(@RequestBody LoginDTO loginDTO)
	    {
	        LoginMesage loginResponse = adminService.loginAdmin(loginDTO);
	        return ResponseEntity.ok(loginResponse);
	    }
	
//	

}