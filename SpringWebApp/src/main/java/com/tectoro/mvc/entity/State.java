package com.tectoro.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_state")
public class State {
	
	@Id
	@Column(name = "state_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stateId;
	@Column(name = "state_name")
	private String stateName;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;
	
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
