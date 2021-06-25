package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDto implements Serializable {

	private static final long serialVersionUID = 406605468415296827L;
	
	private Long cityId;
	private String cityName;
	private Long stateId;
	
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	
	@Override
	public String toString() {
		return "CityDto [cityId=" + cityId + ", cityName=" + cityName + ", stateId=" + stateId + "]";
	}
	
	public CityDto(Long cityId, String cityName, Long stateId) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.stateId = stateId;
	}
	
	public CityDto()	{
		
	}
}
