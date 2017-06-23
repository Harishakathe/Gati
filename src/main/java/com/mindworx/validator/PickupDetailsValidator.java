package com.mindworx.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	
	
	public boolean supports(Class<?> class_ob) {
		return PickupDetails.class.equals(class_ob);
	}

	public void validate(Object target, Errors errors) {
		PickupDetails details = (PickupDetails) target;
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "docket_no", "NotEmpty.docket_no");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "docket_type", "NotEmpty.docket_type");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "docket_category", "NotEmpty.docket_category");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product", "NotEmpty.product");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "booking_basis", "NotEmpty.booking_basis");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_code", "NotEmpty.shipper_code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_name", "NotEmpty.shipper_name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_address1", "NotEmpty.shipper_address1");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_address2", "NotEmpty.shipper_address2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_address3", "NotEmpty.shipper_address3");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_address4", "NotEmpty.shipper_address4");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_city", "NotEmpty.shipper_city");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_pincode", "NotEmpty.shipper_pincode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_oucode", "NotEmpty.shipper_oucode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_phone", "NotEmpty.shipper_phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_mobile", "NotEmpty.shipper_mobile");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_email", "NotEmpty.shipper_email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper_tin", "NotEmpty.shipper_tin");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_code", "NotEmpty.receiver_code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_mobile", "NotEmpty.receiver_mobile");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_name", "NotEmpty.receiver_name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_address1", "NotEmpty.receiver_address1");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_address2", "NotEmpty.receiver_address2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_address3", "NotEmpty.receiver_address3");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_address4", "NotEmpty.receiver_address4");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_city", "NotEmpty.receiver_city");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_pincode", "NotEmpty.receiver_pincode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_oucode", "NotEmpty.receiver_oucode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_phone", "NotEmpty.receiver_phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_email", "NotEmpty.receiver_email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_tin", "NotEmpty.receiver_tin");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "goods_code", "NotEmpty.goods_code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "goods_desc", "NotEmpty.goods_desc");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "booking_oucode", "NotEmpty.booking_oucode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "delivery_oucode", "NotEmpty.delivery_oucode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "no_of_packages", "NotEmpty.no_of_packages");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "package_number_from", "NotEmpty.package_number_from");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "package_number_to", "NotEmpty.package_number_to");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "package_type", "NotEmpty.package_type");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipment_value", "NotEmpty.shipment_value");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "risk", "NotEmpty.risk");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "volume", "NotEmpty.volume");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uom", "NotEmpty.uom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actual_weight", "NotEmpty.actual_weight");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_flag", "NotEmpty.cod_flag");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_dod_in_favor", "NotEmpty.cod_dod_in_favor");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cod_dod_amount", "NotEmpty.cod_dod_amount");         
		
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
		
		if(!numberValidator.valid(details.getPackage_number_from())){
			errors.rejectValue("package_number_from", "Package Number From Must be Number");
		}
		
		if(!numberValidator.valid(details.getPackage_number_to())){
			errors.rejectValue("package_number_to", "Package Number To Must be Number");
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
