package com.tectoro.mvc.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tectoro.mvc.dao.AdminDao;
import com.tectoro.mvc.dto.AdminDto;
import com.tectoro.mvc.dto.AdminSearchCriteria;
import com.tectoro.mvc.entity.Admin;
import com.tectoro.mvc.enums.DateFormatEnum;
import com.tectoro.mvc.enums.GenderEnum;
import com.tectoro.mvc.service.AdminService;
import com.tectoro.mvc.utils.DateAndTimeUtils;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public AdminDto saveAdmin(AdminDto adminDto) {
		Admin admin = convertDtoToEntity.apply(adminDto);
		admin.setCreatedDate(System.currentTimeMillis());
		admin.setModifiedDate(System.currentTimeMillis());
		admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
		admin = adminDao.saveOrUpdateAdmin(admin);
		return convertEntityToDto.apply(admin);
	}

	@Override
	public AdminDto getAdminById(Long adminId) {
		Admin entity = adminDao.getAdminById(adminId);
		return convertEntityToDto.apply(entity);
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto) {
		Admin admin = convertDtoToEntity.apply(adminDto);
		admin.setModifiedDate(System.currentTimeMillis());
		admin.setCreatedDate(adminDto.getCreatedDate());
		admin = adminDao.saveOrUpdateAdmin(admin);
		return convertEntityToDto.apply(admin);
	}
	
	public static Function<AdminDto, Admin> convertDtoToEntity = dto -> {
		Admin admin = null;
		if(dto != null)	{
			admin = new Admin();
			admin.setAddress(dto.getAddress());
			admin.setAge(dto.getAge());
			admin.setEmailId(dto.getEmailId());
			admin.setFirstName(dto.getFirstName());
			admin.setGender(GenderEnum.valueOf(dto.getGender()));
			admin.setIsActiveUser(dto.getIsActiveUser());
			admin.setUserName(dto.getUserName());
			admin.setLastName(dto.getLastName());
			admin.setMobileNumber(dto.getMobileNumber());
			admin.setDateOfBirth(DateAndTimeUtils.convertStringToLocalDate(
					dto.getDateOfBirth(), DateFormatEnum.YYYY_MM_DD));
		}
		return admin;
	};
	
	public static Function<Admin, AdminDto> convertEntityToDto = entity -> {
		AdminDto adminDto = null;
		if(entity != null)	{
			adminDto = new AdminDto();
			adminDto.setAddress(entity.getAddress());
			adminDto.setAdminId(entity.getAdminId());
			adminDto.setAge(entity.getAge());
			adminDto.setDateOfBirth(DateAndTimeUtils.convertLocalDateToString(
					entity.getDateOfBirth(), DateFormatEnum.YYYY_MM_DD));
			adminDto.setEmailId(entity.getEmailId());
			adminDto.setFirstName(entity.getFirstName());
			adminDto.setGender(entity.getGender().name());
			adminDto.setIsActiveUser(entity.getIsActiveUser());
			adminDto.setLastName(entity.getLastName());
			adminDto.setMobileNumber(entity.getMobileNumber());
			adminDto.setUserName(entity.getUserName());
		}
		return adminDto;
	};

	@Override
	public AdminDto getAdminByUserName(String uName) {
		return convertEntityToDto.apply(adminDao.getAdminByUserName(uName));
	}

	@Override
	public AdminDto getAdminByEmail(String email) {
		return convertEntityToDto.apply(adminDao.getAdminByEmail(email));
	}

	@Override
	public List<AdminDto> getAdminsBsdOnSearchCriteria(AdminSearchCriteria searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminDto> getAllAdmins() {
		List<AdminDto> adminDtoList = null;
		List<Admin> admins = adminDao.getAllAdmins(); 
		if(!CollectionUtils.isEmpty(admins))	{
			adminDtoList = admins.stream().map(convertEntityToDto).collect(Collectors.toList());
		}
		return adminDtoList;
	}
}
