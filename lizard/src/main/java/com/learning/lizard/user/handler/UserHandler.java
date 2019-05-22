package com.learning.lizard.user.handler;

import javax.servlet.http.HttpSession;

import com.learning.lizard.exception.BusinessFailureException;
import com.learning.lizard.user.form.UserForm;

public interface UserHandler {
	
	public void registerUser(UserForm form) throws BusinessFailureException;

	public void loginUser(UserForm form ,HttpSession session) throws BusinessFailureException;
	
	public void findUserByID(int userID);
	
}
