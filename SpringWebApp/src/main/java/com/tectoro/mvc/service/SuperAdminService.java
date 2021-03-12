package com.tectoro.mvc.service;

import com.tectoro.mvc.dto.SuperAdminDto;

public interface SuperAdminService {
	public SuperAdminDto saveOrUpdateSuperAdmin(SuperAdminDto spAdminDto);
	public SuperAdminDto getSuperAdminById(Long spAdminId);
}
