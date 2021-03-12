package com.tectoro.mvc.service;

import com.tectoro.mvc.dto.CustomerDto;

public interface CustomerService {
	public CustomerDto saveCustomer(CustomerDto customerDto);
	public CustomerDto updateCustomer(CustomerDto customerDto);
	public CustomerDto getCustomerDtoById(Long customerId);
}
