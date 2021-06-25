package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.City;

public interface CityDao {
	public List<City> getCitiesBsdOnIds(List<Long> cityIds);
	public List<Long> getCityIdsBsdOnState(Long stateId);
}
