package com.learning.lizard.common;

/**
 * This class represents the User session information.
 * 
 * @author abhishek.vishnoi
 */
public class SessionInfo {

	private Long userId;

	private Long storeId;

	private String roleName;

	private String email;

	public SessionInfo() {

		this.storeId = 1L;
	}

	public SessionInfo(Long userId, Long storeId, String roleName,
			String currencySymbol) {
		this.userId = userId;
		this.storeId = storeId;
		this.roleName = roleName;

	}

	public SessionInfo(Long userId, Long storeId, String roleName,
			String email, String firstname, String lastname,
			String currencySymbol) {
		this.userId = userId;
		this.storeId = storeId;
		this.roleName = roleName;
		this.email = email;

	}

	
	public Long getUserId() {
		return userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public Long getStoreId() {
		return storeId;
	}

	
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
