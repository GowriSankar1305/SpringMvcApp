package com.tectoro.mvc.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tectoro.mvc.enums.GenderEnum;

@Entity
@Table(name = "tbl_staff")
public class Staff {
	
	@Id
	@Column(name = "staff_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;
	@Column(name = "staff_code")
	private String staffCode;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "designation_id")
	private Designation designation;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	@Column(name = "address")
	private String address;
	@Column(name = "date_of_joining")
	private LocalDate dateOfJoining;
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "age")
	private Integer age;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "is_active_user")
	private Byte isActiveUser;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
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
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
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
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
