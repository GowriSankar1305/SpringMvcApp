package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto implements Serializable {

	private static final long serialVersionUID = -5108260813180107978L;
	
	private Long countryId;
	private String countryCode;
	private String countryName;
	private Integer phoneCode;
	
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Integer getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(Integer phoneCode) {
		this.phoneCode = phoneCode;
	}
	
	@Override
	public String toString() {
		return "CountryDto [countryId=" + countryId + ", countryCode=" + countryCode + ", countryName=" + countryName
				+ ", phoneCode=" + phoneCode + "]";
	}
}
