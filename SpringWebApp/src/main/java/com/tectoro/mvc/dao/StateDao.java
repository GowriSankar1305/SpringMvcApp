package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.State;

public interface StateDao {
	public List<State> getStatesBsdOnCountry(Long countryId);
	public List<State> getStatesBsdOnIds(List<Long> ids);
	public List<Long> getAllStateIdsBsdOnCountry(Long countryId);
}
