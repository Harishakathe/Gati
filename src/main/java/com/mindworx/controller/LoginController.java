package com.mindworx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LoginController {
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String showLoginRequest() {
		return "login";
	}
	
	@RequestMapping(value = "/loginAdmin",method = RequestMethod.GET)
	public String showAdminLoginRequest() {
		return "loginAdmin";
	}
	
	@RequestMapping(value = "/403",method = RequestMethod.GET)
	public String showAccessDenied() {
		return "accessDenied";
	}
}
