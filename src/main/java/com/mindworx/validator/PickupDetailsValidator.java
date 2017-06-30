package com.mindworx.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindworx.model.PickupDetails;
public class PickupDetailsValidator implements Validator{
	
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	@Autowired
	@Qualifier("numberValidator")
	NumberValidator numberValidator;
	
	@Autowired
	@Qualifier("stringValidator")
	StringValidator stringValidator;
	
	@Autowired
	private Environment env;	
	
	public boolean supports(Class<?> class_ob) {
		return PickupDetails.class.equals(class_ob);
	}

	public void validate(Object target, Errors errors) {
		
		PickupDetails details = (PickupDetails) target;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "docket_no", "NotEmpty.docket_no");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "docket_type", env.getProperty("NotEmpty.docket_type"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "docket_category", env.getProperty("NotEmpty.docket_category"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product", env.getProperty("NotEmpty.product"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "booking_basis", env.getProperty("NotEmpty.booking_basis"));
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_code", env.getProperty("NotEmpty.shipper_code"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_name", env.getProperty("NotEmpty.shipper_name"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_address1", env.getProperty("NotEmpty.shipper_address1"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_address2", env.getProperty("NotEmpty.shipper_address2"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_address3", env.getProperty("NotEmpty.shipper_address3"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_city", env.getProperty("NotEmpty.shipper_city"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_pincode", env.getProperty("NotEmpty.shipper_pincode"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_phone", env.getProperty("NotEmpty.shipper_phone"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_mobile", env.getProperty("NotEmpty.shipper_mobile"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_email", env.getProperty("NotEmpty.shipper_email"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_tin", env.getProperty("NotEmpty.shipper_tin"));
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_code", env.getProperty("NotEmpty.receiver_code"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_mobile", env.getProperty("NotEmpty.receiver_mobile"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_name", env.getProperty("NotEmpty.receiver_name"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_address1", env.getProperty("NotEmpty.receiver_address1"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_address2", env.getProperty("NotEmpty.receiver_address2"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_address3", env.getProperty("NotEmpty.receiver_address3"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_city", env.getProperty("NotEmpty.receiver_city"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_pincode", env.getProperty("NotEmpty.receiver_pincode"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_phone", env.getProperty("NotEmpty.receiver_phone"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_email", env.getProperty("NotEmpty.receiver_email"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_tin", env.getProperty("NotEmpty.receiver_tin"));
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "goods_code", env.getProperty("NotEmpty.goods_code"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "booking_ou", env.getProperty("NotEmpty.booking_oucode"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "delivery_ou", env.getProperty("NotEmpty.delivery_oucode"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "no_of_packages", env.getProperty("NotEmpty.no_of_packages"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "package_type", env.getProperty("NotEmpty.package_type"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipment_value", env.getProperty("NotEmpty.shipment_value"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "risk", env.getProperty("NotEmpty.risk"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "volume", env.getProperty("NotEmpty.volume"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uom", env.getProperty("NotEmpty.uom"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actual_weight", env.getProperty("NotEmpty.actual_weight"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_flag", env.getProperty("NotEmpty.cod_flag"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_dod_in_favor", env.getProperty("NotEmpty.cod_dod_in_favor"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_dod_amount", env.getProperty("NotEmpty.cod_dod_amount"));
		
		/*if(!numberValidator.validDocket(details.getDocket_No())){
			errors.rejectValue("docket_no", "Docket No Must be Valid 9 digit Number");
		}*/
		
		if(!numberValidator.valid(details.getBooking_basis())){
			errors.rejectValue("booking_basis", "Booking Basis Must be Valid");
		}
		
		if(!numberValidator.valid(details.getNo_of_packages())){
			errors.rejectValue("no_of_packages", "No of Packages Must be Number");
		}
		else{
			int No_of_Packages = Integer.parseInt(details.getNo_of_packages());
			if(No_of_Packages<0 || No_of_Packages>100)
				errors.rejectValue("no_of_packages", "No of Packages Beetween 1 to 99");
		}
		if(!numberValidator.valid(details.getNo_of_packages())){
			errors.rejectValue("no_of_packages", "No of Packages Must be Number");
		}
		
		if(!numberValidator.valid(details.getShipment_value())){
			errors.rejectValue("shipment_value", "Shipment Value To Must be Number");			
		}else{
			long shipment_value = Long.parseLong(details.getShipment_value());
			long mlimit = 9999999999L;
			if(shipment_value<0 || shipment_value > mlimit )
				errors.rejectValue("shipment_value", "Shipment Value Beetween 1 to 9999999999");
		}
		
		if(!numberValidator.valid(details.getVolume())){
			errors.rejectValue("volume", "Volume To Must be Number");			
		}else{
			int volume = Integer.parseInt(details.getShipment_value());
			if(volume<0 || volume > 999999 )
				errors.rejectValue("volume", "Volume Beetween 1 to 999999");
		}

		if(!numberValidator.valid(details.getShipper_pincode())){
			errors.rejectValue("volume", "Booking Pincode To Must be Number");			
		}else{
			int pincode = Integer.parseInt(details.getShipper_pincode());
			if(pincode<99999 || pincode >= 999999 )
				errors.rejectValue("volume", "Booking Pincode Must be 9 digit");
		}

		if(!numberValidator.valid(details.getReceiver_pincode())){
			errors.rejectValue("volume", "Delivery Pincode To Must be Number");			
		}else{
			int pincode = Integer.parseInt(details.getReceiver_pincode());
			if(pincode<99999 || pincode >= 999999 )
				errors.rejectValue("volume", "Delivery Pincode Must be 9 digit");
		}
		
		if (details.getPackage_details() == null || details.getPackage_details().size() < 0 || details.getPackage_details().size() > 100) {
			errors.rejectValue("package_details", "Package Details at list 1");
		}
		
		if(!emailValidator.valid(details.getShipper_email())){
			errors.rejectValue("shipper_email", "Shipper Email must Be Valid");
		}
		
		if(!emailValidator.valid(details.getReceiver_email())){
			errors.rejectValue("receiver_email", "Receiver Email must Be Valid");
		}	
		
	}

}
