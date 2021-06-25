package com.tectoro.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.CountryDao;
import com.tectoro.mvc.entity.Country;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
@SuppressWarnings("all")
public class CountryDaoImpl implements CountryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryDaoImpl.class);
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public List<Country> getAllCountries() {
		return hibernateUtils.loadEntities(Country.class);
	}

	@Override
	public Country getCountry(Long countryId) {
		return hibernateUtils.findEntityByPrimaryId(Country.class, countryId);
	}

	@Override
	public int getNoOfCountries() {
		return hibernateUtils.getEntityCount(Country.class);
	}

	@Override
	public List<Long> getAllCountryIds() {
		List<Long> ids = new ArrayList<>();
		Session session = null;
		Query<Long> query = null;
		try	{
			session = hibernateUtils.getSession();
			query = session.createQuery("select countryId from Country order by countryName");
			ids = query.list();
		}
		catch(Exception e)	{
			logger.error("<<<<<<<<<<<<<<<<<<<<<< Exception at getAllCountryIds:: {}",e);
		}
		finally	{
			hibernateUtils.closeSession();
		}
		return ids;
	}

	@Override
	public List<Country> getCountriesByIds(List<Long> ids) {
		Session session = null;
		Criteria criteria = null;
		List<Country> countryList = null;
		try	{
			session = hibernateUtils.getSession();
			criteria = session.createCriteria(Country.class);
			criteria.add(Restrictions.in("countryId", ids));
			criteria.addOrder(Order.asc("countryName"));
			countryList = criteria.list();
		}
		catch(Exception e)	{
			logger.error("<<<<<<<<<<<<<<<<<<<<<< Exception at getCountriesByIds:: {}",e);
		}
		finally {
			hibernateUtils.closeSession();
		}
		return countryList;
	}
}
