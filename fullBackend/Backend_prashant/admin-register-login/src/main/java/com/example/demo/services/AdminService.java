package com.example.demo.services;

import com.example.demo.models.AdminDTO;
import com.example.demo.models.LoginDTO;
import com.example.demo.models.LoginMesage;

public interface AdminService {
	String addAdmin(AdminDTO admindto);
	
	LoginMesage loginAdmin(LoginDTO loginDTO);

}
