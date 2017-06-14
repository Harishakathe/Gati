package com.mindworx.controller;


import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;

import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.dao.PickupDetailsDaoImpl;
import com.mindworx.model.PickupDetails;
import com.mindworx.model.Receiver;
import com.mindworx.model.Shipper;

@Controller
@RequestMapping("/")
public class PickupDetailsReqController {
	
	@Autowired
    private PickupDetailsDao pickupDetailsDao;
	//-------------------Create a Customer Requset --------------------------------------------------------
     
    @RequestMapping(value = "/generate_xml", method = RequestMethod.POST)
    public ResponseEntity<PickupDetails> generateXml(@ModelAttribute("pickupDetails") @Valid PickupDetails pickupDetails,BindingResult result, Model model) {
    	return new ResponseEntity<PickupDetails>(pickupDetails, HttpStatus.OK);
    	/*// Create the JAXBContext
        JAXBContext jc;
		try {
			
			jc = JAXBContext.newInstance(PickupDetails.class);
			// Create the Document
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.newDocument();

	        // Marshal the Object to a Document
	        Marshaller marshaller = jc.createMarshaller();
	        marshaller.marshal(pickupDetails, document);

	        // Output the Document
	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer t = tf.newTransformer();
	        DOMSource source = new DOMSource(document);
	        StreamResult streamResult = new StreamResult(System.out);
	        t.transform(source, streamResult);
	        
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
    	
    	//return new ResponseEntity<PickupDetails>(pickupDetails, HttpStatus.OK);
        if (result.hasErrors()) {
    		System.out.println("error"); ;
    	}*/
    	
    }
    
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
    public ResponseEntity<String> getCustomerDetails(@PathVariable String customerid) {
    	return new ResponseEntity<String>(pickupDetailsDao.getCustomerDetails(customerid), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getPinCodes/{pinCode}", method = RequestMethod.GET)
    public ResponseEntity<String> getPinCodes(@PathVariable String pinCode) {
    	return new ResponseEntity<String>(pickupDetailsDao.getPinCodes(pinCode), HttpStatus.OK);
    }
    	
 
}
