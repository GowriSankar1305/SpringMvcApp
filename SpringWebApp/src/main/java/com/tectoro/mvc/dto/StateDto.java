package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StateDto implements Serializable {

	private static final long serialVersionUID = 1882838126938762060L;
	
	private Long stateId;
	private String stateName;
	private Long countryId;
	
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "StateDto [stateId=" + stateId + ", stateName=" + stateName + ", countryId=" + countryId + "]";
	}
	public StateDto(Long stateId, String stateName, Long countryId) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.countryId = countryId;
	}
	
	public StateDto()	{
		
	}
}
