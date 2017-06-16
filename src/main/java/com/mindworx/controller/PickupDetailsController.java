package com.mindworx.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.mindworx.model.PickupDetails;


@Controller
@RequestMapping("/")
public class PickupDetailsController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
	
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
    
    
    	
 
}
