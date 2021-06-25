package com.tectoro.mvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.FacilityDao;
import com.tectoro.mvc.entity.Facility;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
public class FacilityDaoImpl implements FacilityDao {
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public Facility saveFacility(Facility facility) {
		return hibernateUtils.saveOrUpdateEntity(facility);
	}
	@Override
	public List<Facility> getFacilities() {
		return hibernateUtils.loadEntities(Facility.class);
	}
}
