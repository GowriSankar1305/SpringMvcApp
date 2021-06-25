package com.tectoro.mvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.CityDao;
import com.tectoro.mvc.entity.City;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
public class CityDaoImpl implements CityDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CityDaoImpl.class);
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	@SuppressWarnings("all")
	public List<City> getCitiesBsdOnIds(List<Long> cityIds) {
		Session session = null;
		Criteria criteria = null;
		List<City> cities = null;
		try	{
			session = hibernateUtils.getSession();
			criteria = session.createCriteria(City.class);
			criteria.add(Restrictions.in("cityId", cityIds));
			cities = criteria.list();
		}
		catch(Exception e)	{
			logger.error("<<<<<<<<<<<<<<<<<<<<< Exception at getCitiesBsdOnIds:: {}",e);
		}
		finally {
			hibernateUtils.closeSession();
		}
		return cities;
	}

	@Override
	@SuppressWarnings("all")
	public List<Long> getCityIdsBsdOnState(Long stateId) {
		Session session = null;
		Query<Long> query = null;
		try	{
			session = hibernateUtils.getSession();
			query = session.createQuery("select cityId from City where state.stateId =:stateId order by cityName");
			query.setParameter("stateId", stateId);
			return query.list();	
		}
		catch(Exception e)	{
			logger.error("<<<<<<<<<<<<<<<<<<<<<<< Exception at getCityIdsBsdOnState:: {}",e);
		}
		finally {
			hibernateUtils.closeSession();
		}
		return null;
	}
}