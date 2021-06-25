package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacilityDto implements Serializable {
	
	private static final long serialVersionUID = 7761894791789972649L;
	
	private Integer facilityId;
	private String facilityIcon;
	private String facilityName;
	
	public Integer getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityIcon() {
		return facilityIcon;
	}
	public void setFacilityIcon(String facilityIcon) {
		this.facilityIcon = facilityIcon;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	
	
}
