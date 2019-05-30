package com.learning.lizard.user.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.learning.lizard.exception.BusinessFailureException;
import com.learning.lizard.persistence.UserTbMaster;
import com.learning.lizard.user.form.UserForm;

/**
 * 
 * @author abhishek.vishnoi
 *
 */
public interface UserService {

	public List<UserTbMaster> findAll();
	
	public  List<UserTbMaster> findAllByProperty(HashMap<String, Object> propertiesMap);
	
	public  List<UserTbMaster> findAllByProperty(String propertyName, Object value);
	
	public UserTbMaster findByID(int userID);
	
	public boolean registerUser(UserForm userForm) throws BusinessFailureException;
	
	public boolean loginUser(UserForm userForm,HttpSession session) throws BusinessFailureException;
} 
