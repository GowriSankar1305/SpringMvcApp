package com.tectoro.mvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.CustomerDao;
import com.tectoro.mvc.entity.Customer;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	public Customer saveCustomer(Customer customer) {
		return hibernateUtils.saveEntity(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return hibernateUtils.saveOrUpdateEntity(customer);
	}

	public List<Customer> getAllCustomers() {
		return hibernateUtils.loadEntities(Customer.class);
	}

	public Customer getCustomerById(Long customerId) {
		return hibernateUtils.findEntityByPrimaryId(Customer.class, customerId);
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		return hibernateUtils.findEntityByUniqueProperty(Customer.class, "userName", userName);
	}
}
