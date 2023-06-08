package com.pack.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.exception.AdminNotFoundException;
import com.pack.exception.UserNotFoundException;
import com.pack.model.Admin;
import com.pack.model.User;
import com.pack.service.UserService;
import com.pack.service.AdminService;

@Controller
public class UserController {
	
	
	@Autowired
    UserService adminService;
	@Autowired
    AdminService adminService1;
	
	static final String RD1="redirect:/uviewForm";
	static final Logger logger=LogManager.getLogger(UserController.class);
	static final String ERROR="error";
	static final String RD2="exception";
	
	 @RequestMapping("/addUserForm")  
	 public String add(Model m)  
	 {  
		 
		 m.addAttribute("ad", new  User());  
		 List<Admin> list=adminService1.viewAll();
		  m.addAttribute("list",list);
	     return "userForm";  
	 }
		
	 

	  @PostMapping(value = "/addUser")
	  public  String addStudent(User admin) { 
		  User admin1=new User();
		  admin1=admin;
		   adminService.saveAdmin(admin1);
		   return RD1;
	 
	  
	  }
	  
	  @RequestMapping("/uviewForm") 
	  public String viewemp(Model m){ 
		  List<User> list=adminService.viewAll();
		  m.addAttribute("list",list);
		  return "viewuser"; 
		  }
	  
	  
			
			  @RequestMapping("/editUser") 
			  public String edit( @RequestParam("loginid") int  id,Model m)
			  {
				  User ad=null;
				  String page=null;
			 
			  try
			  {
			  if (adminService.getAdminById(id).isPresent())
				 {
					  ad=adminService.getAdminById(id).get();
					  m.addAttribute("editUserForm",ad);
					  page="editActionUser";
					 
				 }
				 else if (adminService.getAdminById(id).isEmpty())
				 {
					 
				  throw new AdminNotFoundException();
				   
					  }
					}
					  catch(AdminNotFoundException e)
					  {
						  m.addAttribute(RD2,e);
					    	page="ExceptionPage";
						  
					  }

			return page;
			
			  
			 
			  
			  }
			 
			  
			
			  
			  
			  
			  @GetMapping(value="/deleteUser/{id}")
			  public String   delete(@PathVariable int id,Model m) {
				  User admin=null;
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
				  m.addAttribute(RD2,e);
				  page="ExceptionPage";
				  
				  }
				  
				  return page;
			  }
			  
			  
			  @RequestMapping("/usearch") 
			  public String viewemp1(Model m){ 
				  m.addAttribute("ad",new User());
				  return "searchUser"; 
				  }
			
			  
			
			  
			  @RequestMapping("/udisplay") 
			  public String viewemp1(Model m, @RequestParam("corpid") int id){ 
				 
				  m.addAttribute("corpid",id);
				  String page=null;
				  try
				  {
					  if(adminService.getAdminById(id).isPresent())
					  {
				  List<User> list=adminService.getAdminById1(id);
				  m.addAttribute("list",list);
				  page= "displayusers"; 
				  }
				 
					  else if(adminService.getAdminById(id).isEmpty())
				  {

					  throw new UserNotFoundException();
					  }
				  
				  }
			  catch(UserNotFoundException e)
			  {
			  m.addAttribute(RD2,e.toString());
			  page="Exceptionpage";
			  
			  }
			  
			  return page;
			  
}
			  
}
