package com.mindworx.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class DashboardController {
	
	private static final Logger log = Logger.getLogger(DashboardController.class);
	
		
	@RequestMapping(value={"", "/", "dashboard"}, method = RequestMethod.GET)
	public String getIndex(ModelMap map) {
		return "dashboard";
	}	
}
