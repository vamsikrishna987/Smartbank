package com.pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class LoginController {

	 

	@GetMapping("/admin")
		public String admin() {
			return "index";
		}

	@RequestMapping("/user")
		public String user() {
			return "sear";
		}

		@GetMapping("/all")
		public String all() {
			return "allpage";
		}
	}