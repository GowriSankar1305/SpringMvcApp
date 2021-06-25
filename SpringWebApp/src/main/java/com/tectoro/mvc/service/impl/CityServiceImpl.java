package com.tectoro.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tectoro.mvc.dao.CityDao;
import com.tectoro.mvc.dto.CityDto;
import com.tectoro.mvc.dto.PaginationDto;
import com.tectoro.mvc.entity.City;
import com.tectoro.mvc.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDao cityDao;
	
	@Override
	public List<CityDto> getCountriesByIds(List<Long> ids) {
		List<City> cities = cityDao.getCitiesBsdOnIds(ids);
		if(!CollectionUtils.isEmpty(cities))	{
			return cities.stream().map(convertEntityToDto).collect(Collectors.toList());
		}
		return null;
	}
	
	public static Function<City, CityDto> convertEntityToDto = entity -> {
		if(null != entity)	{
			return new CityDto(entity.getCityId(), entity.getCityName(), entity.getState().getStateId());
		}
		return null;
	};
	
	@Override
	public List<PaginationDto> getPaginatedDataForCitiesBsdOnState(Long stateId) {
		List<Long> idNos = cityDao.getCityIdsBsdOnState(stateId);
		List<PaginationDto> list = null;
		if(!CollectionUtils.isEmpty(idNos))	{
			list = new ArrayList<>();
			int counter = 0,pointer = 0;
			StringBuilder ids = new StringBuilder();
			for(int i = 1 ; i <= idNos.size() ; i++)	{
				pointer++;
				ids.append(idNos.get(i-1)).append(",");
				if(i % 50 == 0)	{
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
}
