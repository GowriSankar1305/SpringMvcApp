package com.tectoro.mvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.tectoro.mvc.dao.AdminDao;
import com.tectoro.mvc.dto.AdminSearchCriteria;
import com.tectoro.mvc.entity.Admin;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
@SuppressWarnings("all")
public class AdminDaoImpl implements AdminDao {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public Admin saveOrUpdateAdmin(Admin admin) {
		return hibernateUtils.saveOrUpdateEntity(admin);
	}

	@Override
	public List<Admin> getAdminsBsdOnSearchCriteria(AdminSearchCriteria searchCriteria) {
		List<Admin> admins = null;
		try(Session session = hibernateUtils.getSession())	{
			Criteria criteria = session.createCriteria(Admin.class);
			if(null != searchCriteria)	{
				if(StringUtils.hasText(searchCriteria.getAdminFirstName()))	{
					//searchCriteria.getAdminFirstNameOperation()
					//criteria.add(Restrictions.)
				}
				
				criteria.setFirstResult(searchCriteria.getFirstResult());
				criteria.setMaxResults(searchCriteria.getMaxResult());
			}
			admins = criteria.list();	
			
		}
		catch(Exception e)	{
			logger.error("<<<<<<<<<<<<<<<<< Exception at AdminDaoImpl.getAdminsBsdOnSearchCriteria :: {}",e);
			return null;
		}
		return admins;
	}

	@Override
	public Admin getAdminById(Long adminId) {
		return hibernateUtils.findEntityByPrimaryId(Admin.class, adminId);
	}

	@Override
	public Admin getAdminByUserName(String userName) {
		return hibernateUtils.findEntityByUniqueProperty(Admin.class, "userName", userName);
	}

	@Override
	public Admin getAdminByEmail(String email) {
		return hibernateUtils.findEntityByUniqueProperty(Admin.class, "emailId", email);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return hibernateUtils.loadEntities(Admin.class);
	}
}
