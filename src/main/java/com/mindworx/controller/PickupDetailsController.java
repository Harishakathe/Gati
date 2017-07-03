package com.mindworx.controller;


import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	@RequestMapping(value = "/recipt1/{docket_no}",method = RequestMethod.GET)
	public String getPrintReceipt1(@PathVariable("docket_no") int docket_no,ModelMap map) {
		PickupDetails pickupDetails = pickupDetailsDao.getPickupDetails(docket_no);
		log.info(pickupDetails);
		map.addAttribute("pickupDetails",pickupDetails);
		return "recipt1";
	}
	//-------------------Create a Customer Requset --------------------------------------------------------
     
    @RequestMapping(value = "/generate_xml", method = RequestMethod.POST)
    public ResponseEntity<PickupDetails> generateXml(@ModelAttribute("pickupDetails") @Valid PickupDetails pickupDetails,BindingResult result, Model model) {
    	
    	return new ResponseEntity<PickupDetails>(pickupDetails, HttpStatus.OK);
    	
    }
    
}
