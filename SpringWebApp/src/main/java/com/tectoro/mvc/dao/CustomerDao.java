package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.Customer;

public interface CustomerDao {
	public Customer saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(Long customerId);
}
