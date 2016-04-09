package com.neusoft.model;

/**
 * UserTId entity. @author MyEclipse Persistence Tools
 */

public class UserT implements java.io.Serializable {

	// Fields

	private String userName;
	private String userId;
	private String userPassword;

	// Constructors

	/** default constructor */
	public UserT() {
	}

	/** full constructor */
	public UserT(String userName, String userId, String userPassword) {
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


}