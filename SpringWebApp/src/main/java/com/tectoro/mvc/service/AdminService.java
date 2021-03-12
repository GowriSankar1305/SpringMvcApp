package com.tectoro.mvc.service;

import com.tectoro.mvc.dto.AdminDto;

public interface AdminService {
	public AdminDto saveAdmin(AdminDto adminDto);
	public AdminDto updateAdmin(AdminDto adminDto);
	public AdminDto getAdminById(Long adminId);
}
