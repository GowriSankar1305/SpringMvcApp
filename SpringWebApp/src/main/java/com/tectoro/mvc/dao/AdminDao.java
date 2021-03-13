package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.Admin;

public interface AdminDao {
	public Admin saveOrUpdateAdmin(Admin admin);
	public List<Admin> getAllAdmins();
	public Admin getAdminById(Long adminId);
	public Admin getAdminByUserName(String userName);
}
