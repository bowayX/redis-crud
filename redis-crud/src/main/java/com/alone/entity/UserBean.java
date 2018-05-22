package com.alone.entity;

import java.io.Serializable;

public class UserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String userNumber;
	private String password;
	private String oldUserNumber;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldUserNumber() {
		return oldUserNumber;
	}
	public void setOldUserNumber(String oldUserNumber) {
		this.oldUserNumber = oldUserNumber;
	}
	/** 
	 * Creates a new instance of UserBean. 
	 * 
	 * @param userId
	 * @param userNumber
	 * @param password
	 * @param oldUserNumber 
	 */  
	public UserBean(String userId, String userNumber, String password, String oldUserNumber) {
		super();
		this.userId = userId;
		this.userNumber = userNumber;
		this.password = password;
		this.oldUserNumber = oldUserNumber;
	}
	/** 
	 * Creates a new instance of UserBean. 
	 *  
	 */  
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userNumber=" + userNumber + ", password=" + password
				+ ", oldUserNumber=" + oldUserNumber + "]";
	}
}
