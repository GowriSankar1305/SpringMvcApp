package com.tectoro.mvc.service;

import java.util.List;

import com.tectoro.mvc.dto.CityDto;
import com.tectoro.mvc.dto.PaginationDto;

public interface CityService {
	public List<CityDto> getCountriesByIds(List<Long> ids);
	public List<PaginationDto> getPaginatedDataForCitiesBsdOnState(Long stateId);
}
