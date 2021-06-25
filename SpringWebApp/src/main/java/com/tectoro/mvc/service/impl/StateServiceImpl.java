package com.tectoro.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tectoro.mvc.dao.StateDao;
import com.tectoro.mvc.dto.PaginationDto;
import com.tectoro.mvc.dto.StateDto;
import com.tectoro.mvc.entity.State;
import com.tectoro.mvc.service.StateService;

@Service
public class StateServiceImpl implements StateService {
	
	@Autowired
	private StateDao stateDao;
	
	@Override
	public List<StateDto> getStatesBsdOnCountry(Long countryId) {
		List<State> states = stateDao.getStatesBsdOnCountry(countryId);
		return states.stream().map(convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public List<StateDto> getSatesBsdOnIds(List<Long> stateIds) {
		List<State> states = stateDao.getStatesBsdOnIds(stateIds);
		if(!CollectionUtils.isEmpty(states))	{
			return states.stream().map(convertEntityToDto).collect(Collectors.toList());
		}
		return null;
	}
	
	public static Function<State, StateDto> convertEntityToDto = entity -> {
		StateDto dto = null;
		if(null != entity)	{
			dto = new StateDto();
			dto.setCountryId(entity.getCountry().getCountryId());
			dto.setStateId(entity.getStateId());
			dto.setStateName(entity.getStateName());
		}
		return dto;
	};

	@Override
	public List<PaginationDto> getPaginatedDataOfStatesBsdOnCountry(Long countryId) {
		List<Long> idNos = stateDao.getAllStateIdsBsdOnCountry(countryId);
		List<PaginationDto> list = null;
		if(!CollectionUtils.isEmpty(idNos))	{
			list = new ArrayList<>();
			int counter = 0,pointer = 0;
			StringBuilder ids = new StringBuilder();
			for(int i = 1 ; i <= idNos.size() ; i++)	{
				pointer++;
				ids.append(idNos.get(i-1)).append(",");
				if(i % 30 == 0)	{
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
