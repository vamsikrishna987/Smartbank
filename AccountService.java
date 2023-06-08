package com.pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

 
import com.pack.model.Account;
import com.pack.repository.AccountRepository;

@Service
public class AccountService {

	
	@Autowired
	AccountRepository adminRepository;
	@Query(value="select * from account where corpid=?",nativeQuery=true)
	 
	public void saveAdmin(Account admin) {
		
 	adminRepository.save(admin);
	 
		
	}
	
	 
	 public List<Account> viewAll()
	 {
		 
		return adminRepository.findAll();
		
	 }
	 
		
		  public Optional<Account> getAdminById(String id){
			  
		      return adminRepository.findById(id); 
		  }
		  

		  
		  public void deleteAdmin(Account admin)
		  {
			  
			  adminRepository.delete(admin);
		  }


		public List<Account> findAll(int id) {
		
			return adminRepository.findAll(id);
		}


		public List<Account> getAdminById(int id) {
			return adminRepository.findById(id);
		}
		 
		  
		  
			 		
		 
			 
		  
		  
}
