package com.tectoro.mvc.dto;

import java.io.Serializable;

public class SuperAdminDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long superAdminId;
	private String superAdminName;
	private Byte isActiveUser;
	private String userName;
	private String emailId;
	private String mobileNumber;
	private Long createdDate;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getSuperAdminId() {
		return superAdminId;
	}
	public Long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}
	public void setSuperAdminId(Long superAdminId) {
		this.superAdminId = superAdminId;
	}
	public String getSuperAdminName() {
		return superAdminName;
	}
	public void setSuperAdminName(String superAdminName) {
		this.superAdminName = superAdminName;
	}
	public Byte getIsActiveUser() {
		return isActiveUser;
	}
	public void setIsActiveUser(Byte isActiveUser) {
		this.isActiveUser = isActiveUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	@Override
	public String toString() {
		return "SuperAdminDto [superAdminId=" + superAdminId + ", superAdminName=" + superAdminName + ", isActiveUser="
				+ isActiveUser + ", userName=" + userName + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber
				+ "]";
	}
}
