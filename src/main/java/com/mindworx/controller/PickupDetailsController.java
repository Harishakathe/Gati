package com.mindworx.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.dao.UserDao;
import com.mindworx.model.PickupDetails;
import com.mindworx.model.User;


@Controller
public class PickupDetailsController {
	
	@Autowired
    private PickupDetailsDao pickupDetailsDao;
	
	@Autowired
	private UserDao userDao;
	
	private static final Logger log = Logger.getLogger(PickupDetailsController.class);
	
	@RequestMapping(value = "/user/recipt/{docket_no}",method = RequestMethod.GET)
	public String getPrintReceipt(@PathVariable("docket_no") int docket_no,ModelMap map) {
		PickupDetails pickupDetails = pickupDetailsDao.getPickupDetails(docket_no);
		log.info(pickupDetails);
		map.addAttribute("user",getPrincipal());
		map.addAttribute("pickupDetails",pickupDetails);
		return "recipt";
	}
	@RequestMapping(value = "/user/pickuprequest",method = RequestMethod.GET)
	public String showPickupRequest(ModelMap map) {
		map.addAttribute("user",getPrincipal());
		return "pickupRequest";
	}
	
	@RequestMapping(value = "/user/docketprint",method = RequestMethod.GET)
	public String showDocketPrint() {
		return "docketPrint";
	}
	
	@RequestMapping(value = "/user/lableprint",method = RequestMethod.GET)
	public String showLableRequest() {
		return "lablePrint";
	}
	
	
	private User getPrincipal(){
		String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }            
        User user = userDao.getByLoginId(userName);
        user.setCusPword("");
        return user;        
    }
	
	
}
