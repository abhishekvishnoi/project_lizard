package com.learning.lizard.user.form.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.learning.lizard.user.form.UserForm;

/**
 * 
 * Validator for user Login form
 * 
 * @author abhishek.vishnoi
 *
 */
@Component
public class UserFormValidator implements Validator {

	private static final String EMAIL_ID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object command, Errors errors) {

		UserForm userForm = (UserForm) command;

		/*
		 * Validation for email pattern.
		 */
		if (StringUtils.isNotBlank(userForm.getUser_email())) {

			if (!(userForm.getUser_email().matches(EMAIL_ID_PATTERN))) 
				errors.rejectValue("user_email", "Please enter a valid email","Please enter a valid email");
			
		} else
			
			errors.rejectValue("user_email", "Please enter email","Please enter email");
		

		/*
		 * Validation for user password.
		 */
		if (!(StringUtils.isNotBlank(userForm.getUser_password()))) 
			errors.rejectValue("user_password", "Please enter password","Please enter password");

	}

}
