package com.mindworx.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.model.PickupDetails;


@Controller
@RequestMapping("/")
public class PickupDetailsController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
	
	@Autowired
    private PickupDetailsDao pickupDetailsDao;
	
	private static final Logger log = Logger.getLogger(PickupDetailsController.class);
	
	@RequestMapping(value = "/recipt/{docket_no}",method = RequestMethod.GET)
	public String getPrintReceipt(@PathVariable("docket_no") int docket_no,ModelMap map) {
		PickupDetails pickupDetails = pickupDetailsDao.getPickupDetails(docket_no);
		log.info(pickupDetails);
		map.addAttribute("pickupDetails",pickupDetails);
		return "recipt";
	}
}
