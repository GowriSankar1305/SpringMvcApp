package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.Country;

public interface CountryDao {
	public List<Country> getAllCountries();
	public Country getCountry(Long countryId);
	public int getNoOfCountries();
	public List<Long> getAllCountryIds();
	public List<Country> getCountriesByIds(List<Long> ids);
}
