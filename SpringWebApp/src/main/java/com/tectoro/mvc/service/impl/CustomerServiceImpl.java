package com.tectoro.mvc.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tectoro.mvc.dao.CustomerDao;
import com.tectoro.mvc.dto.CustomerDto;
import com.tectoro.mvc.entity.Customer;
import com.tectoro.mvc.service.CustomerService;
import com.tectoro.mvc.utils.DateAndTimeUtils;
import com.tectoro.mvc.utils.DateFormatEnum;
import com.tectoro.mvc.utils.GenderEnum;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = convertDtotoEntity.apply(customerDto);
		customer.setCreatedDate(System.currentTimeMillis());
		customer.setModifiedDate(System.currentTimeMillis());
		customer = customerDao.saveCustomer(customer);
		return convertEntityToDto.apply(customer);
	}

	@Override
	public CustomerDto getCustomerDtoById(Long customerId) {
		Customer customer = customerDao.getCustomerById(customerId);
		return convertEntityToDto.apply(customer);
	}
	
	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		Customer customer = convertDtotoEntity.apply(customerDto);
		customer.setModifiedDate(System.currentTimeMillis());
		customer.setCreatedDate(customerDto.getCreatedDate());
		customer = customerDao.saveCustomer(customer);
		return convertEntityToDto.apply(customer);
	}

	public static Function<CustomerDto, Customer> convertDtotoEntity = dto -> {
		Customer customer = null;
		if(dto != null)	{
			customer = new Customer();
			customer.setAddress(dto.getAddress());
			customer.setAge(dto.getAge());
			customer.setDateOfBirth(DateAndTimeUtils.convertStringtoSqlDate(
					dto.getDateOfBirth(), DateFormatEnum.YYYY_MM_DD));
			customer.setCustomerId(dto.getCustomerId());
			customer.setEmailId(dto.getEmailId());
			customer.setCustomerId(dto.getCustomerId());
			customer.setCreatedDate(dto.getCreatedDate());
			customer.setFirstName(dto.getFirstName());
			customer.setGender(GenderEnum.valueOf(dto.getGender()));
			customer.setIsActiveUser(dto.getIsActiveUser());
			customer.setIscreatedFromAdminJourney(dto.getCreatedByAdmin());
			customer.setIscreatedFromCustomerJourney(dto.getCreatedByCustomer());
			customer.setUserName(dto.getUserName());
			customer.setPassword(dto.getPassword());
			customer.setMobileNumber(dto.getMobileNumber());
		}
		return customer;
	};
	
	public static Function<Customer, CustomerDto> convertEntityToDto = entity -> {
		CustomerDto customerDto = null;
		if(entity != null)	{
			customerDto = new CustomerDto();
			customerDto.setAddress(entity.getAddress());
			customerDto.setAge(entity.getAge());
			customerDto.setCreatedByAdmin(entity.getIscreatedFromAdminJourney());
			customerDto.setCreatedByCustomer(entity.getIscreatedFromCustomerJourney());
			customerDto.setCreatedDate(entity.getCreatedDate());
			customerDto.setCustomerId(entity.getCustomerId());
			customerDto.setDateOfBirth(DateAndTimeUtils.convertSqlDateToString(
					entity.getDateOfBirth(), DateFormatEnum.YYYY_MM_DD));
			customerDto.setEmailId(entity.getEmailId());
			customerDto.setFirstName(entity.getFirstName());
			customerDto.setGender(entity.getGender().name());
			customerDto.setIsActiveUser(entity.getIsActiveUser());
			customerDto.setLastName(entity.getLastName());
			customerDto.setMobileNumber(entity.getMobileNumber());
			customerDto.setPassword(entity.getPassword());
			customerDto.setUserName(entity.getUserName());
		}
		return customerDto;
	};

}
