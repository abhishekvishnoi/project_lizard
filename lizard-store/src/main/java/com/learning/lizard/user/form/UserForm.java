package com.learning.lizard.user.form;

public class UserForm {

	private String error_message;
	
	private String user_name;
	
	private String user_email;
	
	private String user_password;
	
	private String confirm_user_password;

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getConfirm_user_password() {
		return confirm_user_password;
	}

	public void setConfirm_user_password(String confirm_user_password) {
		this.confirm_user_password = confirm_user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	
}
