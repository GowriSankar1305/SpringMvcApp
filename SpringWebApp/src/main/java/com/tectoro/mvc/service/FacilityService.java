package com.tectoro.mvc.service;

import java.util.List;

import com.tectoro.mvc.dto.FacilityDto;

public interface FacilityService {
	public List<FacilityDto> getAllFacilities();
	public FacilityDto saveFacility(FacilityDto facility);
}
