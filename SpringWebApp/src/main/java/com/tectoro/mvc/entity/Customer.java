package com.tectoro.mvc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tectoro.mvc.enums.GenderEnum;
import com.tectoro.mvc.enums.IdentityEnum;


@Entity
@Table(name = "tbl_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "mobile_number",nullable = false,unique = true)
	private String mobileNumber;
	@Column(name = "email_id",nullable = false,unique = true)
	private String emailId;
	@Column(name = "address")
	private String address;
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	@Column(name = "created_date")
	private Long createdDate;
	@Column(name = "modified_date")
	private Long modifiedDate;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	@Column(name = "age")
	private Integer age;
	@Column(name = "user_name",unique = true,nullable = false)
	private String userName;
	@Column(name = "password",nullable = false)
	private String password;
	@Column(name = "is_active_user")
	private Byte isActiveUser;
	@Column(name = "is_created_from_admin_journey")
	private Byte iscreatedFromAdminJourney;
	@Column(name = "is_created_from_customer_journey")
	private Byte iscreatedFromCustomerJourney;
	@Enumerated(EnumType.STRING)
	@Column(name = "identity_type")
	private IdentityEnum identityType;
	@Column(name = "identity_number")
	private String identityNumber;
	
	public IdentityEnum getIdentityType() {
		return identityType;
	}
	public void setIdentityType(IdentityEnum identityType) {
		this.identityType = identityType;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public Byte getIscreatedFromAdminJourney() {
		return iscreatedFromAdminJourney;
	}
	public void setIscreatedFromAdminJourney(Byte iscreatedFromAdminJourney) {
		this.iscreatedFromAdminJourney = iscreatedFromAdminJourney;
	}
	public Byte getIscreatedFromCustomerJourney() {
		return iscreatedFromCustomerJourney;
	}
	public void setIscreatedFromCustomerJourney(Byte iscreatedFromCustomerJourney) {
		this.iscreatedFromCustomerJourney = iscreatedFromCustomerJourney;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	public Long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}
	public Long getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Byte getIsActiveUser() {
		return isActiveUser;
	}
	public void setIsActiveUser(Byte isActiveUser) {
		this.isActiveUser = isActiveUser;
	}
}
