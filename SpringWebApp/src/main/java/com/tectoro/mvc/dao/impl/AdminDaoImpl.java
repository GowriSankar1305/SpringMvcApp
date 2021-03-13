package com.tectoro.mvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.AdminDao;
import com.tectoro.mvc.entity.Admin;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public Admin saveOrUpdateAdmin(Admin admin) {
		return hibernateUtils.saveOrUpdateEntity(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return hibernateUtils.loadEntities(Admin.class);
	}

	@Override
	public Admin getAdminById(Long adminId) {
		return hibernateUtils.findEntityByPrimaryId(Admin.class, adminId);
	}

	@Override
	public Admin getAdminByUserName(String userName) {
		return hibernateUtils.findEntityByUniqueProperty(Admin.class, "userName", userName);
	}
}
