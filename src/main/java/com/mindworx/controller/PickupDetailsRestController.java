package com.mindworx.controller;


import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.model.CustomerList;
import com.mindworx.model.JsonResponse;
import com.mindworx.model.PickupDetails;

@RestController
public class PickupDetailsRestController {
	
	@Autowired
    private PickupDetailsDao pickupDetailsDao;
	
	
	@Autowired
	@Qualifier("pickupDetailsValidator")
	private Validator validator;
	
	private static final Logger logger = Logger.getLogger(PickupDetailsRestController.class);
	
	@RequestMapping(value = "/testconnection", method = RequestMethod.GET)
    public void testConnection() {
    	 System.out.println("count : "+pickupDetailsDao.getGEMS_WS_CUST_AUTO_prod_vals());
    }
	
	@RequestMapping(value = "/testtable", method = RequestMethod.GET)
    public ResponseEntity<String> descTable() {
    	 
    	 return new ResponseEntity<String>(pickupDetailsDao.descTable(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getBookingStation/{cust_code}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBookingStation(@PathVariable String cust_code) {
    	return new ResponseEntity<String>(pickupDetailsDao.getBookingStation(cust_code), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getGoodType", method = RequestMethod.GET)
    public ResponseEntity<String> getGoodType() {
    	return new ResponseEntity<String>(pickupDetailsDao.getGoodType(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getCustomerDetails/{customerid}", method = RequestMethod.GET)
    public ResponseEntity<CustomerList> getCustomerDetails(@PathVariable String customerid) {
    	
    	CustomerList customers = new CustomerList();
    	customers.setCustomers(pickupDetailsDao.getCustomerDetails(customerid));
    	
    	return new ResponseEntity<CustomerList>(customers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getPinCodes/{pinCode}", method = RequestMethod.GET)
    public ResponseEntity<String> getPinCodes(@PathVariable String pinCode) {
    	return new ResponseEntity<String>(pickupDetailsDao.getPinCodes(pinCode), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getEsscode/{receiver_pinCode}", method = RequestMethod.GET)
    public ResponseEntity<String> getEsscode(@PathVariable String receiver_pinCode) {
    	return new ResponseEntity<String>(pickupDetailsDao.getEsscode(receiver_pinCode), HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/getContractNo/{cust_code}", method = RequestMethod.GET)
    public ResponseEntity<String> getContractNo(@PathVariable String cust_code) {
    	return new ResponseEntity<String>(pickupDetailsDao.getContractNo(cust_code), HttpStatus.OK);
    }
    
        
	@RequestMapping(value = "/validate_xml", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> validateXml(@RequestBody @Valid PickupDetails pickupDetails,UriComponentsBuilder ucBuilder, BindingResult result ) {
		
		logger.info("pickupDetails:"+pickupDetails);
		
		JsonResponse res = new JsonResponse();
		
		validator.validate(pickupDetails, result);
						
		if(!result.hasErrors()){
			logger.info("My Validation success Start ValidateXML Procedure");
			String str = pickupDetailsDao.validateXML(pickupDetails);			
	        JsonParser parser = new JsonParser();
	        JsonObject o = parser.parse(str).getAsJsonObject();
	        if(o.get("error_flag").getAsString().equalsIgnoreCase("N")){
	        	String output = pickupDetailsDao.generateDocketNo(pickupDetails);
	        	logger.info("generated Docket No:"+output);
	        	o = parser.parse(output).getAsJsonObject();
	        	
	        	if(o.get("error_flag").getAsString().equalsIgnoreCase("N")){
	        		pickupDetails.setDocket_no(o.get("Docket_No").getAsString());
	        		
	        		output = pickupDetailsDao.insertDocket(pickupDetails);
	        		o = parser.parse(output).getAsJsonObject();
	        		
	        		if(o.get("error_flag").getAsString().equalsIgnoreCase("N")){
	        			logger.info("Docket Inserted Success. Your Docket No:"+o.get("Docket_No").getAsLong());
	        			res.setStatus("SUCCESS");
			        	res.setMessage("Docket Inserted Success. Your Docket No:"+o.get("Docket_No").getAsLong());
			        	res.setResult(o.get("Docket_No").getAsLong());
	        		}else{	        			
			        	res.setStatus("FAIL");
			        	res.setMessage("Inserting Error");
			        	res.setResult(o.get("error_msg").getAsString());
	        		}
	        	}
	        	else{
	        		res.setStatus("FAIL");
		        	res.setMessage("Docket Generation Error");
		        	res.setResult(o.get("error_msg").getAsString());
	        	}
	        }else{
	        	res.setStatus("FAIL");
	        	res.setMessage("Validation XML Error");
	        	res.setResult(o.get("error_msg").getAsString());
	        }
		}
		else{
			res.setStatus("FAIL");
			res.setMessage("Invalied Pickup Details.");
			
			logger.error("validation error:"+result.getAllErrors());
			
			List<FieldError> allErrors = result.getFieldErrors();
            JsonObject obj = new JsonObject();
            for (FieldError objectError : allErrors) {
            	obj.addProperty(objectError.getField(), objectError.getCode());
            }
            
            Gson gson = new Gson();            
            res.setResult(gson.fromJson(obj,Object.class));
            
		}		
		return new ResponseEntity<JsonResponse>(res,HttpStatus.OK);
	}
	
	
}
