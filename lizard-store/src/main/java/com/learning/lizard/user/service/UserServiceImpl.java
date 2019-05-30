package com.learning.lizard.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.lizard.dao.GenericDAO;
import com.learning.lizard.exception.BFECommonKeys;
import com.learning.lizard.exception.BusinessFailureException;
import com.learning.lizard.persistence.UserTbMaster;
import com.learning.lizard.user.form.UserForm;

@Service
public class UserServiceImpl implements UserService {

	private GenericDAO<UserTbMaster> dao;

	@Autowired
	public void setDAO(GenericDAO<UserTbMaster> daoToSet) {
		dao = daoToSet;
		dao.setClazz(UserTbMaster.class);
	}

	@Transactional
	public List<UserTbMaster> findAll() {
		return dao.findAll();
	}

	@Transactional
	public List<UserTbMaster> findAllByProperty(HashMap<String, Object> propertiesMap) {
		return dao.findAllByProperty(propertiesMap);
	}

	@Transactional
	public UserTbMaster findByID(int userID) {
		return dao.findByID(userID);
	}

	@Override
	public List<UserTbMaster> findAllByProperty(String propertyName, Object value) {
		return dao.findAllByProperty(propertyName, value);
	}

	/**
	 * Register a new user. Create a new entry in userTbMaster table in the
	 * database. Throws BFE if the email already exists in the database.
	 */
	@Transactional
	public boolean registerUser(UserForm userForm) throws BusinessFailureException {

		if (findAllByProperty("userEmail", userForm.getUser_email()).size() > 0) {
			throw new BusinessFailureException(BFECommonKeys.USER_EMAIL_ALREADY_EXISTS, "Email Already Exists");
		} else {

			UserTbMaster newUser = new UserTbMaster();
			newUser.setUserName(userForm.getUser_name());
			newUser.setUserEmail(userForm.getUser_email());
			newUser.setUserPassword(userForm.getUser_password());
			newUser.setDateAdded(new Date());
			dao.create(newUser);
			return true;
		}
	}

	/**
	 * Login Gateway into the Application . Search for the email in UserTbMaster
	 * and match Password.
	 */
	@Transactional
	public boolean loginUser(UserForm userForm, HttpSession session) throws BusinessFailureException {

		List<UserTbMaster> users = findAllByProperty("userEmail", userForm.getUser_email());

		if (users.size() == 0) {

			throw new BusinessFailureException(BFECommonKeys.USER_EMAIL_DOESNOT_EXISTS,
					"User Email is not yet registered !");

		} else if (users.size() > 1) {

			throw new BusinessFailureException(BFECommonKeys.USER_EMAIL_MULTIPLEACCOUNTS_EXISTS,
					"Multiple User Accounts exist for the same email . Please contact Admin to technical assistance !! ");
		} else {

			UserTbMaster user = users.get(0);

			if (user.getUserPassword().equals(userForm.getUser_password())) {

				session.setAttribute("userID", user.getUserId());
				session.setAttribute("loginStatus", true);
				return true;
			} else
				throw new BusinessFailureException(BFECommonKeys.USER_ACCOUNT_INVALID_PASSWORD_EXISTS,
						"Invalid Password !!");
		}

	}

}
