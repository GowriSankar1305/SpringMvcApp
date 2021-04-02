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
@Table(name = "tbl_city")
public class City {
	
	@Id
	@Column(name = "city_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cityId;
	@Column(name = "city_name")
	private String cityName;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")
	private State state;
	
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
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
}
