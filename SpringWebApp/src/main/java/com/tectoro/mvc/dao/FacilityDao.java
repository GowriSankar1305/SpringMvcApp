package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.Facility;

public interface FacilityDao {
	public Facility saveFacility(Facility facility);
	public List<Facility> getFacilities();
}
