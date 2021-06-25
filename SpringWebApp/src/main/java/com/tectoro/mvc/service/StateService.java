package com.tectoro.mvc.service;

import java.util.List;

import com.tectoro.mvc.dto.PaginationDto;
import com.tectoro.mvc.dto.StateDto;

public interface StateService {
	public List<StateDto> getStatesBsdOnCountry(Long countryId);
	public List<StateDto> getSatesBsdOnIds(List<Long> stateIds);
	public List<PaginationDto> getPaginatedDataOfStatesBsdOnCountry(Long countryId);
}
