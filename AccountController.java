package com.pack.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.pack.exception.AdminNotFoundException;
import com.pack.model.Account;
import com.pack.model.Admin;
import com.pack.service.AccountService;
import com.pack.service.AdminService;

@Controller
public class AccountController {
	
	
	@Autowired
    AccountService adminService;
	@Autowired
    AdminService adminService1;
	
	static final org.apache.log4j.Logger logger=LogManager.getLogger(AccountController.class);
	
	static final String RD1="redirect:/aviewForm";
	static final String RD2="ExceptionPage";
	static final String RD3="exception";
	 @RequestMapping("/addAccountForm")  
	 public String add(Model m)  
	 {  
		 
		 m.addAttribute("ad", new  Account());
		 List<Admin> list=adminService1.viewAll();
		  m.addAttribute("list",list);
	     return "accountForm";  
	 }
		
	 

	  @PostMapping(value = "/addAccount")
	  public  String addStudent(Account admin) { 
		   adminService.saveAdmin(admin);
		   return RD1;
	 
	  
	  }
	  
	  @RequestMapping("/aviewForm") 
	  public String viewemp(Model m){ 
		  List<Account> list=adminService.viewAll();
		  m.addAttribute("list",list);
		  return "viewaccount"; 
		  }


	  @RequestMapping("/search") 
	  public String viewemp1(Model m){ 
		  m.addAttribute("ad",new Account());
		  return "searchAccount"; 
		  }
	
	  
	
	  
	  @RequestMapping("/displayaccount") 
	  public String viewemp1(Model m, @RequestParam("corpid") int id){ 
		 m.addAttribute("corpid",id);
		  List<Account> list=adminService.getAdminById(id);
		  m.addAttribute("list",list);
		  return "displayaccounts"; 
	  
}

	  
	  
	  
	  
	  
			  @RequestMapping("/editAccount") 
			  public String edit( @RequestParam("accnum") String id,Model m)
			  {
			      Account acc;
				  String page=null;
			 
			  try
			  {
			  if (adminService.getAdminById(id).isPresent())
				 {
					acc=adminService.getAdminById(id).get();
					  m.addAttribute("editAccountForm",acc);
					  page="editActionAccount";
					 
				 }
				 else if (adminService.getAdminById(id).isEmpty())
				 {
					 
				  throw new AdminNotFoundException();
				   
					  }
					}
					  catch(AdminNotFoundException e)
					  {
						  m.addAttribute(RD3,e);
					    	page=RD2;
						  
					  }

			return page;
			 }
			 
			  
			 
			  
			  
			  @GetMapping(value="/deleteAccount/{id}")
			  public String delete(@PathVariable String id,Model m) {
				  Account admin = null;
				  String page=null; 
				  try {
					  if (adminService.getAdminById(id).isPresent())
						 { 
				  admin=adminService.getAdminById(id).get();
				  adminService.deleteAdmin(admin);
				  page=RD1; 
				  } 
				else if   (adminService.getAdminById(id).isEmpty()) {
					logger.info(admin);
				  throw new AdminNotFoundException();
				  
				  } 
					  }
				  catch(AdminNotFoundException e)
				  {
				  m.addAttribute(RD3,e);
				  page=RD2;
				  
				  }
				  
				  return page;
			  }
			  
			  
			  @RequestMapping("/viewacc") 
			  public String viewemp2(Model m, @RequestParam("accnum")String id){

			      Account acc;
				  String page=null;
			 
			  try
			  {
			  if (adminService.getAdminById(id).isPresent())
				 {
					acc=adminService.getAdminById(id).get();
					  m.addAttribute("editAccountForm",acc);
					  page="viewacc";
					 
				 }
				 else if (adminService.getAdminById(id).isEmpty())
				 {
					 
				  throw new AdminNotFoundException();
				   
					  }
					}
					  catch(AdminNotFoundException e)
					  {
						  m.addAttribute(RD3,e);
					    	page=RD2;
						  
					  }

			return page;
				  }
			  
			  
			  
}
