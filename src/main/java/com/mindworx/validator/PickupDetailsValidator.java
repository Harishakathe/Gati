package com.mindworx.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mindworx.model.PickupDetails;


public class PickupDetailsValidator implements Validator{

	public boolean supports(Class<?> class_ob) {
		return PickupDetails.class.equals(class_ob);
	}

	public void validate(Object target, Errors errors) {
		PickupDetails details = (PickupDetails) target;
	}

}
