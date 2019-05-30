package com.learning.lizard.user.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.lizard.exception.BusinessFailureException;
import com.learning.lizard.user.form.UserForm;
import com.learning.lizard.user.service.UserService;

@Component
public class UserHandlerImpl implements UserHandler {

	@Autowired
	private UserService userService;

	@Override
	public void registerUser(UserForm userForm) throws BusinessFailureException {

		userService.registerUser(userForm);

	}

	@Override
	public void loginUser(UserForm userForm, HttpSession session) throws BusinessFailureException {

		userService.loginUser(userForm , session);

	}

	@Override
	public void findUserByID(int userID) {
		
		userService.findByID(userID);
	}

}
