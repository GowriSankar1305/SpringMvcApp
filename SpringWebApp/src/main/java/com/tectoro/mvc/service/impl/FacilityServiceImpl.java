package com.tectoro.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tectoro.mvc.dao.FacilityDao;
import com.tectoro.mvc.dto.FacilityDto;
import com.tectoro.mvc.entity.Facility;
import com.tectoro.mvc.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService {
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityServiceImpl.class);
	
	@Autowired
	private FacilityDao facilityDao;
	
	@Override
	public List<FacilityDto> getAllFacilities() {
		List<FacilityDto> facilityList = null;
		logger.info("******************* Start of  FacilityServiceImpl.getAllFacilities *******************");
		List<Facility> facilities =  facilityDao.getFacilities();
		if(!CollectionUtils.isEmpty(facilities))	{
			facilityList = new ArrayList<>();
			for(Facility source : facilities)	{
				FacilityDto target = new FacilityDto();
				BeanUtils.copyProperties(source, target);
				facilityList.add(target);
			}
		}
		logger.info("******************* End of  FacilityServiceImpl.getAllFacilities *******************");
		return facilityList;
	}

	@Override
	public FacilityDto saveFacility(FacilityDto facility) {
		logger.info("******************** Start of FacilityServiceImpl.saveFacility ******************");
		Facility facilityEntity = new Facility();
		BeanUtils.copyProperties(facility, facilityEntity);
		facilityEntity = facilityDao.saveFacility(facilityEntity);
		BeanUtils.copyProperties(facilityEntity, facility);
		logger.info("******************** End of FacilityServiceImpl.saveFacility ******************");
		return facility;
	}
}
