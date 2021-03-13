package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.SuperAdmin;

public interface SuperAdminDao {
	public SuperAdmin saveOrUpdateSuperAdmin(SuperAdmin spAdmin);
	public SuperAdmin getSuperAdminById(Long spAdminId);
	public List<SuperAdmin> getAllSuperAdmins();
	public SuperAdmin getSuperAdminByUserName(String userName);
}
