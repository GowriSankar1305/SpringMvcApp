package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.dto.AdminSearchCriteria;
import com.tectoro.mvc.entity.Admin;

public interface AdminDao {
	public Admin saveOrUpdateAdmin(Admin admin);
	public List<Admin> getAdminsBsdOnSearchCriteria(AdminSearchCriteria criteria);
	public Admin getAdminById(Long adminId);
	public Admin getAdminByUserName(String userName);
	public Admin getAdminByEmail(String email);
	public List<Admin> getAllAdmins();
}
