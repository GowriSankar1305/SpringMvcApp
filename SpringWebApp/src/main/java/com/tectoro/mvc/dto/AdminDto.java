package com.tectoro.mvc.dto;

import java.io.Serializable;

public class AdminDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long adminId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emailId;
	private String dateOfBirth;
	private String gender;
	private String address;
	private Integer age;
	private String userName;
	private Byte isActiveUser;
	private String password;
	private Long createdDate;
	
	public Long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Byte getIsActiveUser() {
		return isActiveUser;
	}
	public void setIsActiveUser(Byte isActiveUser) {
		this.isActiveUser = isActiveUser;
	}
	
	@Override
	public String toString() {
		return "AdminDto [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", address=" + address + ", age=" + age + ", userName=" + userName
				+ ", isActiveUser=" + isActiveUser + "]";
	}
}
