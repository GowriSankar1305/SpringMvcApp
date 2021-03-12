package com.tectoro.mvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.SuperAdminDao;
import com.tectoro.mvc.entity.SuperAdmin;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
public class SuperAdminDaoImpl implements SuperAdminDao {
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public SuperAdmin saveOrUpdateSuperAdmin(SuperAdmin spAdmin) {
		return hibernateUtils.saveOrUpdateEntity(spAdmin);
	}

	@Override
	public SuperAdmin getSuperAdminById(Long spAdminId) {
		return hibernateUtils.findEntityByPrimaryId(SuperAdmin.class, spAdminId);
	}

	@Override
	public List<SuperAdmin> getAllSuperAdmins() {
		return hibernateUtils.loadEntities(SuperAdmin.class);
	}
}
