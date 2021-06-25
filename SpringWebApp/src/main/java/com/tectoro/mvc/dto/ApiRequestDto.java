package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiRequestDto implements Serializable {

	private static final long serialVersionUID = -7459577867474383787L;
	
	private String emailId;
	private String userName;
	private String hotelName;

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	@Override
	public String toString() {
		return "ApiRequestDto [emailId=" + emailId + ", userName=" + userName + ", hotelName=" + hotelName + "]";
	}
}
