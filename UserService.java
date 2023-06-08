package com.pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.pack.model.User;
import com.pack.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository adminRepository;
	
	 
	public void saveAdmin(User admin) {
		
 	adminRepository.save(admin);
	 
		
	}
	
	 public List<User> viewAll()
	 {
		 
		return adminRepository.findAll();

	 }
	 
		
		  public Optional<User> getAdminById(int id){
			  
		      return adminRepository.findById(id); 
		  }
		  
		  public void deleteAdmin(User admin)
		  {
			  
			  adminRepository.delete(admin);
		  }
		 
	  public List<User> getAdminById1(int id){
			  
		      return adminRepository.findById1(id); 
		  }
		  	  
		  
}
