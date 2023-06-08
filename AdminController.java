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
import com.pack.model.Admin;
import com.pack.service.AdminService;

@Controller
public class AdminController {
	
	static final Logger logger=LogManager.getLogger(AdminController.class);
	static final String ERROR="error";
	
	@Autowired
    AdminService adminService;
	
	
	
	  @RequestMapping("/home") 
	  public String home() {
	  
	  return "index";
	  }
	 
	
	 @RequestMapping("/addAdminForm")  
	 public String add(Model m)  
	 {  
		 
		 m.addAttribute("ad", new  Admin());  
	     return "adminForm";  
	 }
		
	 

	  @PostMapping(value = "/addAdmin")
	  public  String addStudent(Admin admin) {
		  Admin admin1=new Admin();
		  admin1=admin;
		   adminService.saveAdmin(admin1);
		   return "redirect:/viewForm";
	 
	  
	  }
	  
	  @RequestMapping("/viewForm") 
	  public String viewemp(Model m){ 
		  List<Admin> list=adminService.viewAll();
		  m.addAttribute("list",list);
		  return "view"; 
		  }
	  
	  
			
			  @RequestMapping("/editAdmin") 
			  public String edit( @RequestParam("corpid") int  id,Model m)
			  {
			      Admin ad1=null;
				  String page=null;
			 
			  try
			  {
			  if (adminService.getAdminById(id).isPresent())
				 {
					  ad1=adminService.getAdminById(id).get();
					  m.addAttribute("editAdminForm",ad1);
					  page="editAction";
					 
				 }
				 else if (adminService.getAdminById(id).isEmpty())
				 {
					 
				  throw new AdminNotFoundException();
				   
					  }
					}
					  catch(AdminNotFoundException e)
					  {
						  m.addAttribute("exception",e);
					    	page="ExceptionPage";
						  
					  }

			return page;
			
			  
			 
			  
			  }
			 
			  
			  
			  @GetMapping(value="/deleteAdmin/{id}")
			  public String   delete(@PathVariable int id,Model m) {
				  Admin admin=null;
				  String page=null; 
				  try {
					  if (adminService.getAdminById(id).isPresent())
						 { 
				  admin=adminService.getAdminById(id).get();
				  adminService.deleteAdmin(admin);
				  page="redirect:/viewForm"; 
				  } 
				else if   (adminService.getAdminById(id).isEmpty()) {
					logger.info(admin);
				  throw new AdminNotFoundException();
				  
				  } 
					  }
				  catch(AdminNotFoundException e)
				  {
				  m.addAttribute("exception",e);
				  page="Exceptionpage";
				  
				  }
				  
				  return page;
			  }
			  
			  
			  
}
