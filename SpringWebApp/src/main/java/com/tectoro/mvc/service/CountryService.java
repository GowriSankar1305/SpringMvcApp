package com.tectoro.mvc.service;

import java.util.List;

import com.tectoro.mvc.dto.CountryDto;
import com.tectoro.mvc.dto.PaginationDto;

public interface CountryService {
	public List<CountryDto> getAllCountries();
	public CountryDto getCountryById(Long countryId);
	public int getNoOfCountries();
	public List<PaginationDto> getPaginatedDataOfCountries();
	public List<CountryDto> getCountriesByIds(List<Long> ids);
}
