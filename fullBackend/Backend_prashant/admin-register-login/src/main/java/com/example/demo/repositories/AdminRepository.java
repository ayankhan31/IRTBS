package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
	
	  Optional<Admin> findOneByAdminIdAndPassword(int adminId, String password);
	    Admin findByAdminId(int adminId);

}
