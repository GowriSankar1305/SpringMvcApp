package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = -952879349807071692L;
	
	private int statusCode;
	private String successMessage;
	private String errorMessage;
	private boolean isEmailExists;
	private boolean isUserNameExists;
	private boolean isHotelNameExists;
	
	public boolean isEmailExists() {
		return isEmailExists;
	}
	public void setEmailExists(boolean isEmailExists) {
		this.isEmailExists = isEmailExists;
	}
	public boolean isUserNameExists() {
		return isUserNameExists;
	}
	public void setUserNameExists(boolean isUserNameExists) {
		this.isUserNameExists = isUserNameExists;
	}
	public boolean isHotelNameExists() {
		return isHotelNameExists;
	}
	public void setHotelNameExists(boolean isHotelNameExists) {
		this.isHotelNameExists = isHotelNameExists;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
