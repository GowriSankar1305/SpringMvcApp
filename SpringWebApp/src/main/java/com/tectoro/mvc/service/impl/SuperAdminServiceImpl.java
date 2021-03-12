package com.tectoro.mvc.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tectoro.mvc.dao.SuperAdminDao;
import com.tectoro.mvc.dto.SuperAdminDto;
import com.tectoro.mvc.entity.SuperAdmin;
import com.tectoro.mvc.service.SuperAdminService;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
	
	@Autowired
	private SuperAdminDao spAdminDao;
	
	@Override
	public SuperAdminDto saveOrUpdateSuperAdmin(SuperAdminDto spAdminDto) {
		SuperAdmin savedEnity = spAdminDao.saveOrUpdateSuperAdmin(convertDtoToEntity.apply(spAdminDto));
		return convertEntityToDto.apply(savedEnity);
	}

	@Override
	public SuperAdminDto getSuperAdminById(Long spAdminId) {
		SuperAdmin entity = spAdminDao.getSuperAdminById(spAdminId);
		return convertEntityToDto.apply(entity);
	}
	
	public static Function<SuperAdminDto, SuperAdmin> convertDtoToEntity = dto -> {
		SuperAdmin superAdmin = null;
		if(dto != null)	{
			superAdmin = new SuperAdmin();
			superAdmin.setEmailId(dto.getEmailId());
			superAdmin.setMobileNumber(dto.getMobileNumber());
			superAdmin.setSuperAdminName(dto.getSuperAdminName());
			superAdmin.setUserName(dto.getUserName());
			superAdmin.setCreatedDate(System.currentTimeMillis());
		}
		return superAdmin;
	};
	
	public static Function<SuperAdmin, SuperAdminDto> convertEntityToDto = entity -> {
		SuperAdminDto superAdminDto = null;
		if(entity != null)	{
			superAdminDto = new SuperAdminDto();
			superAdminDto.setCreatedDate(entity.getCreatedDate());
			superAdminDto.setEmailId(entity.getEmailId());
			superAdminDto.setIsActiveUser(entity.getIsActiveUser());
			superAdminDto.setMobileNumber(entity.getMobileNumber());
			superAdminDto.setSuperAdminName(entity.getSuperAdminName());
			superAdminDto.setUserName(entity.getUserName());
		}
		return superAdminDto;
	};
}
