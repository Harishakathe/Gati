package com.mindworx.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.model.AjaxResponseBody;
import com.mindworx.model.PickupDetails;
import com.mindworx.validator.PickupDetailsValidator;

@RestController
public class PickupDetailsRestController {
	
	@Autowired
    private PickupDetailsDao pickupDetailsDao;
	
	private static final Logger logger = Logger.getLogger(PickupDetailsRestController.class);
	
	@RequestMapping(value = "/validate_xml", method = RequestMethod.POST)
    public ResponseEntity<?> validateXml(@ModelAttribute("pickupDetails") @Valid PickupDetails pickupDetails,BindingResult result, Model model) {
		
		new PickupDetailsValidator().validate(pickupDetails , result);
		
		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}

		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		
		
		AjaxResponseBody responce = new AjaxResponseBody();
		
        //If error, just return a 400 bad request, along with the error message
        if (result.hasErrors()) {

        	responce.setMsg(result.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }
        String str = pickupDetailsDao.validateXML(pickupDetails);
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(str).getAsJsonObject();


        responce.setMsg(o.get("error_flag").getAsString());
        
		return ResponseEntity.ok(result);
	}
}
