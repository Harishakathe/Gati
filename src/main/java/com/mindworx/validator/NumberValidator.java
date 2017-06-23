package com.mindworx.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
@Component("numberValidator")
public class NumberValidator {
	private Pattern pattern,pattern_m,pattern_d;
	private Matcher matcher;

	String INTERGER_PATTERN = "[0-9]+";
	String MOBILE_PATTERN = "[0-9]{10}";
	String DOCKET_PATTERN = "[0-9]{9}";
	
	public NumberValidator() {
		pattern = Pattern.compile(INTERGER_PATTERN);
		pattern_m = Pattern.compile(MOBILE_PATTERN);
		pattern_d = Pattern.compile(DOCKET_PATTERN);
	}

	public boolean valid(final String number) {
		matcher = pattern.matcher(number);
		return matcher.matches();
	}
	public boolean valid_mo(final String number) {
		matcher = pattern_m.matcher(number);
		return matcher.matches();
	}

	public boolean validDocket(String docket_No) {
		matcher = pattern_d.matcher(docket_No);
		return matcher.matches();
	}
}
