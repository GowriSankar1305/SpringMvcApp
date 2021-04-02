package com.tectoro.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_facility")
public class Facility {
	
	@Id
	@Column(name = "facility_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer facilityId;
	@Column(name = "facility_icon")
	private String facilityIcon;
	@Column(name = "facility_name")
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
