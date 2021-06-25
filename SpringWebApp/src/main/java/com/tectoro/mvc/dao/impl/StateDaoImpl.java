package com.tectoro.mvc.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.StateDao;
import com.tectoro.mvc.entity.State;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
public class StateDaoImpl implements StateDao {
	
	private static final Logger logger = LoggerFactory.getLogger(StateDaoImpl.class);
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public List<State> getStatesBsdOnCountry(Long countryId) {
		Map<String, Serializable> dataMap = new HashMap<>();
		dataMap.put("country.countryId", countryId);
		return hibernateUtils.loadEntitiesBsdOnSearchCriteria(State.class, dataMap);
	}

	@Override
	@SuppressWarnings("all")
	public List<State> getStatesBsdOnIds(List<Long> ids) {
		Session session = null;
		Criteria criteria = null;
		List<State> states = null;
		try	{
			session = hibernateUtils.getSession();
			criteria = session.createCriteria(State.class);
			criteria.add(Restrictions.in("stateId", ids));
			states = criteria.list();
		}
		catch (Exception e) {
			logger.error("<<<<<<<<<<<<<<<<<<<<<<< Exception in getStatesBsdOnIds:: {}",e);
		}
		finally {
			hibernateUtils.closeSession();
		}
		return states;
	}

	@Override
	@SuppressWarnings("all")
	public List<Long> getAllStateIdsBsdOnCountry(Long countryId) {
			List<Long> ids = new ArrayList<>();
			Session session = null;
			Query<Long> query = null;
			try	{
				session = hibernateUtils.getSession();
				query = session.createQuery("select stateId from State where country.countryId =:countryId order by stateName");
				query.setParameter("countryId", countryId);
				ids = query.list();
			}
			catch(Exception e)	{
				logger.error("<<<<<<<<<<<<<<<<<<<<<< Exception at getAllStateIds:: {}",e);
			}
			finally	{
				hibernateUtils.closeSession();
			}
			return ids;	
	}
}
