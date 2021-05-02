package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminSearchCriteria implements Serializable {

	private static final long serialVersionUID = 5692341849941531252L;
	
	private String adminFirstName;
	private String adminFirstNameOperation;
	private String adminFirstNameOperator;
	private String adminLastName;
	private String adminLastNameOperation;
	private String adminLastNameOperator;
	private String adminEmail;
	private String adminEmailOperation;
	private String adminEmailOperator;
	private String adminMobileNumber;
	private String adminMobileNumberOperation;
	private String adminMobileNumberOperator;
	private Integer adminAge;
	private String adminAgeOperation;
	private String adminAgeOperator;
	private String adminGender;
	private String adminGenderOperation;
	private String adminGenderOperator;
	private Integer firstResult;
	private Integer maxResult;
	private Long totalCount;
	
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public Integer getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public String getAdminFirstNameOperation() {
		return adminFirstNameOperation;
	}
	public void setAdminFirstNameOperation(String adminFirstNameOperation) {
		this.adminFirstNameOperation = adminFirstNameOperation;
	}
	public String getAdminFirstNameOperator() {
		return adminFirstNameOperator;
	}
	public void setAdminFirstNameOperator(String adminFirstNameOperator) {
		this.adminFirstNameOperator = adminFirstNameOperator;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	public String getAdminLastNameOperation() {
		return adminLastNameOperation;
	}
	public void setAdminLastNameOperation(String adminLastNameOperation) {
		this.adminLastNameOperation = adminLastNameOperation;
	}
	public String getAdminLastNameOperator() {
		return adminLastNameOperator;
	}
	public void setAdminLastNameOperator(String adminLastNameOperator) {
		this.adminLastNameOperator = adminLastNameOperator;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminEmailOperation() {
		return adminEmailOperation;
	}
	public void setAdminEmailOperation(String adminEmailOperation) {
		this.adminEmailOperation = adminEmailOperation;
	}
	public String getAdminEmailOperator() {
		return adminEmailOperator;
	}
	public void setAdminEmailOperator(String adminEmailOperator) {
		this.adminEmailOperator = adminEmailOperator;
	}
	public String getAdminMobileNumber() {
		return adminMobileNumber;
	}
	public void setAdminMobileNumber(String adminMobileNumber) {
		this.adminMobileNumber = adminMobileNumber;
	}
	public String getAdminMobileNumberOperation() {
		return adminMobileNumberOperation;
	}
	public void setAdminMobileNumberOperation(String adminMobileNumberOperation) {
		this.adminMobileNumberOperation = adminMobileNumberOperation;
	}
	public String getAdminMobileNumberOperator() {
		return adminMobileNumberOperator;
	}
	public void setAdminMobileNumberOperator(String adminMobileNumberOperator) {
		this.adminMobileNumberOperator = adminMobileNumberOperator;
	}
	public Integer getAdminAge() {
		return adminAge;
	}
	public void setAdminAge(Integer adminAge) {
		this.adminAge = adminAge;
	}
	public String getAdminAgeOperation() {
		return adminAgeOperation;
	}
	public void setAdminAgeOperation(String adminAgeOperation) {
		this.adminAgeOperation = adminAgeOperation;
	}
	public String getAdminAgeOperator() {
		return adminAgeOperator;
	}
	public void setAdminAgeOperator(String adminAgeOperator) {
		this.adminAgeOperator = adminAgeOperator;
	}
	public String getAdminGender() {
		return adminGender;
	}
	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}
	public String getAdminGenderOperation() {
		return adminGenderOperation;
	}
	public void setAdminGenderOperation(String adminGenderOperation) {
		this.adminGenderOperation = adminGenderOperation;
	}
	public String getAdminGenderOperator() {
		return adminGenderOperator;
	}
	public void setAdminGenderOperator(String adminGenderOperator) {
		this.adminGenderOperator = adminGenderOperator;
	}
	
}
