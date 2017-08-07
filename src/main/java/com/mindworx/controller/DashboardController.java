package com.mindworx.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindworx.dao.UserDao;
import com.mindworx.model.User;



@Controller
public class DashboardController {
	
	private static final Logger log = Logger.getLogger(DashboardController.class);
	
	@Autowired
	private UserDao userDao;
		
	@RequestMapping(value={"/", "/dashboard"}, method = RequestMethod.GET)
	public String getIndex(ModelMap map,Principal principal) {
		
		map.addAttribute("user",getPrincipal());
		return "dashboard";
	}
	
	private User getPrincipal(){
		if(SecurityContextHolder.getContext().getAuthentication()!=null){
			String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }            
	        return userDao.getByLoginId(userName); 
		}
		return null;
		       
    }
}
