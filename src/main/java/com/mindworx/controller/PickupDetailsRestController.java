package com.mindworx.controller;


import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.model.AjaxResponseBody;
import com.mindworx.model.CustomerList;
import com.mindworx.model.PickupDetails;
import com.mindworx.validator.PickupDetailsValidator;

@RestController
public class PickupDetailsRestController {
	
	@Autowired
    private PickupDetailsDao pickupDetailsDao;
	
	private static final Logger logger = Logger.getLogger(PickupDetailsRestController.class);
	
	@RequestMapping(value = "/testconnection", method = RequestMethod.GET)
    public void testConnection() {
    	 System.out.println("count : "+pickupDetailsDao.getGEMS_WS_CUST_AUTO_prod_vals());
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
    
    
		
	@RequestMapping(value = "/validate_xml", method = RequestMethod.POST)
    public ResponseEntity<?> validateXml(@Valid @RequestBody PickupDetails pickupDetails,UriComponentsBuilder ucBuilder) {
		//logs debug message
		if(logger.isDebugEnabled()){
			logger.info(pickupDetails);
		}
		
		AjaxResponseBody responce = new AjaxResponseBody();
		//If error, just return a 400 bad request, along with the error message
        
        String str = pickupDetailsDao.validateXML(pickupDetails);
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(str).getAsJsonObject();


        responce.setMsg(o.get("error_flag").getAsString());
        
        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(resultJson.toString(), headers, HttpStatus.OK);*/
        
		return ResponseEntity.ok(responce);
	}
}
