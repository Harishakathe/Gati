package com.mindworx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.model.PickupDetails;
import com.mindworx.validator.PickupDetailsValidator;

@RestController
public class PickupDetailsRestController {
	
	@Autowired
    private PickupDetailsDao pickupDetailsDao;
	
	@RequestMapping(value = "/validate_xml", method = RequestMethod.POST)
    public ResponseEntity<String> validateXml(@ModelAttribute("pickupDetails") @Valid PickupDetails pickupDetails,BindingResult result, Model model) {
		
		new PickupDetailsValidator().validate(pickupDetails , result);
		
		//pickupDetailsDao.validateXML(pickupDetails);
		return new ResponseEntity<String>("Validate Successfully", HttpStatus.OK);
	}
}
