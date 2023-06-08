package com.pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.pack.model.Admin;
import com.pack.repository.AdminRepository;

@Service
public class AdminService {

	
	@Autowired
	AdminRepository adminRepository;
	
	 
	public void saveAdmin(Admin admin) {
		
 	adminRepository.save(admin);
	 
		
	}
	
	 public List<Admin> viewAll()
	 {
		 
		return adminRepository.findAll();
		
	 }
	 
		
		  public Optional<Admin> getAdminById(int id){
			  
		      return adminRepository.findById(id); 
		  }
		  
		  public void deleteAdmin(Admin admin)
		  {
			  
			  adminRepository.delete(admin);
		  }
		 
		  
		  
}
