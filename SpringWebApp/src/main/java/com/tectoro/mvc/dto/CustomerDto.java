package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long customerId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emailId;
	private String gender;
	private Integer age;
	private String userName;
	private Byte isActiveUser;
	private Byte createdByAdmin;
	private Byte createdByCustomer;
	private String password;
	private String address;
	private Long createdDate;
	private String dateOfBirth;
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public Byte getCreatedByAdmin() {
		return createdByAdmin;
	}
	public void setCreatedByAdmin(Byte createdByAdmin) {
		this.createdByAdmin = createdByAdmin;
	}
	public Byte getCreatedByCustomer() {
		return createdByCustomer;
	}
	public void setCreatedByCustomer(Byte createdByCustomer) {
		this.createdByCustomer = createdByCustomer;
	}
	
	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", gender=" + gender + ", age=" + age
				+ ", userName=" + userName + ", isActiveUser=" + isActiveUser + ", createdByAdmin=" + createdByAdmin
				+ ", createdByCustomer=" + createdByCustomer + "]";
	}
}
