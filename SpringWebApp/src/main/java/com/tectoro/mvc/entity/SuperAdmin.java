package com.tectoro.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_super_admin")
public class SuperAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "super_admin_id")
	private Long superAdminId;
	@Column(name = "super_admin_name")
	private String superAdminName;
	@Column(name = "created_date")
	private Long createdDate;
	@Column(name = "is_active_user")
	private Byte isActiveUser;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	public Long getSuperAdminId() {
		return superAdminId;
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
	public Long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}
