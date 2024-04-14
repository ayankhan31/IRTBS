package com.example.demo.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.Admin;
import com.example.demo.models.AdminDTO;
import com.example.demo.models.LoginDTO;
import com.example.demo.models.LoginMesage;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.services.AdminService;

@Service
public class AdminImpl implements AdminService{
	
	@Autowired
	private AdminRepository repo;
	
	@Autowired
     private PasswordEncoder passwordEncoder;
	
	@Override
	public String addAdmin(AdminDTO admindto) {
		
		Admin adm = new Admin(
				admindto.getAdminId(),
				admindto.getAdminName(),
				this.passwordEncoder.encode(admindto.getPassword())
				);
		
		repo.save(adm);
		return adm.getAdminName();
				
		
	}
	
	
	  AdminDTO admindto;
	  
	    @Override
	    public LoginMesage  loginAdmin(LoginDTO loginDTO) {
	        String msg = "";
	        Admin adm1 = repo.findByAdminId(loginDTO.getAdminId());
	        if (adm1 != null) {
	            String password = loginDTO.getPassword();
	            String encodedPassword = adm1.getPassword();
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            if (isPwdRight) {
	                Optional<Admin> employee = repo.findOneByAdminIdAndPassword(loginDTO.getAdminId(), encodedPassword);
	                if (employee.isPresent()) {
	                    return new LoginMesage("Login Success", true);
	                } else {
	                    return new LoginMesage("Login Failed", false);
	                }
	            } else {
	                return new LoginMesage("password Not Match", false);
	            }
	        }else {
	            return new LoginMesage("AdminID not exits", false);
	        }
	    }
	

}
