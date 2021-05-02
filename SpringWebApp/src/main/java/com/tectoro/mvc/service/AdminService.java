package com.tectoro.mvc.service;

import java.util.List;

import com.tectoro.mvc.dto.AdminDto;
import com.tectoro.mvc.dto.AdminSearchCriteria;

public interface AdminService {
	public AdminDto saveAdmin(AdminDto adminDto);
	public AdminDto updateAdmin(AdminDto adminDto);
	public AdminDto getAdminById(Long adminId);
	public AdminDto getAdminByUserName(String uName);
	public AdminDto getAdminByEmail(String email);
	public List<AdminDto> getAdminsBsdOnSearchCriteria(AdminSearchCriteria searchCriteria);
	public List<AdminDto> getAllAdmins();
}
