package com.mindworx.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("stringValidator")
public class StringValidator {
	private Pattern pattern;
	private Matcher matcher;

	String STRING_PATTERN = "[a-zA-Z]+";
	
	public StringValidator() {
		pattern = Pattern.compile(STRING_PATTERN);
	}

	public boolean valid(final String str) {
		matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
}
