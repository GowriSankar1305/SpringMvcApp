package com.tectoro.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tectoro.mvc.dao.CountryDao;
import com.tectoro.mvc.dto.CountryDto;
import com.tectoro.mvc.dto.PaginationDto;
import com.tectoro.mvc.entity.Country;
import com.tectoro.mvc.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	@Autowired
	private CountryDao countryDao;
	
	@Override
	public List<CountryDto> getAllCountries() {
		List<Country> countries = countryDao.getAllCountries();
		List<CountryDto> countryList = null;
		if(!CollectionUtils.isEmpty(countries))	{
			countryList = new ArrayList<>();
			for(Country source : countries)	{
				CountryDto target = new CountryDto();
				BeanUtils.copyProperties(source, target);
				countryList.add(target);
			}
		}
		return countryList;
	}

	@Override
	public CountryDto getCountryById(Long countryId) {
		CountryDto target = null;
		Country source = countryDao.getCountry(countryId);
		if(null != source)	{
			target = new CountryDto();
			BeanUtils.copyProperties(source, target,Country.class);
		}
		return target;
	}

	@Override
	public int getNoOfCountries() {
		return countryDao.getNoOfCountries();
	}

	@Override
	public List<PaginationDto> getPaginatedDataOfCountries() {
		List<Long> idNos = countryDao.getAllCountryIds();
		List<PaginationDto> list = null;
		if(!CollectionUtils.isEmpty(idNos))	{
			list = new ArrayList<>();
			int counter = 0,pointer = 0;
			StringBuilder ids = new StringBuilder();
			for(int i = 1 ; i <= idNos.size() ; i++)	{
				pointer++;
				ids.append(idNos.get(i-1)).append(",");
				if(i % 10 == 0)	{
					pointer = 0;counter++;
					list.add(new PaginationDto(counter, ids.toString().substring(0, ids.length() - 1),counter == 1 ? true : false));
					ids = new StringBuilder();
				}
				else if(i == idNos.size() && pointer > 0) {
					counter++;
					list.add(new PaginationDto(counter, ids.toString().substring(0, ids.length() - 1),counter == 1 ? true : false));
				}
			}
		}
		return list;
	}

	@Override
	public List<CountryDto> getCountriesByIds(List<Long> ids) {
		List<CountryDto> dtoList = null;
		List<Country> countriesList = countryDao.getCountriesByIds(ids);
		if(!CollectionUtils.isEmpty(countriesList))	{
			dtoList = new ArrayList<>();
			for(Country source : countriesList)	{
				CountryDto target = new CountryDto();
				BeanUtils.copyProperties(source, target);
				dtoList.add(target);
			}
		}
		return dtoList;
	}
}
