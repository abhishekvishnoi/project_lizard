package com.learning.lizard.exception;

public class BusinessFailureException extends Exception {

	private static final long serialVersionUID = -3291422724811389251L;

	private Long root_cause_id;

	private String root_cause_message;

	public Long getRoot_cause_id() {
		return root_cause_id;
	}

	public void setRoot_cause_id(Long root_cause_id) {
		this.root_cause_id = root_cause_id;
	}

	public String getRoot_cause_message() {
		return root_cause_message;
	}

	public void setRoot_cause_message(String root_cause_message) {
		this.root_cause_message = root_cause_message;
	}

	public BusinessFailureException(Long root_cause_id, String root_cause_message) {
		this.root_cause_id = root_cause_id;
		this.root_cause_message = root_cause_message;
	}

}
