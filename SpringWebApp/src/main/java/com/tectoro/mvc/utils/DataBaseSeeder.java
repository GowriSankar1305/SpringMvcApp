package com.tectoro.mvc.utils;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.tectoro.mvc.dao.AdminDao;
import com.tectoro.mvc.dao.CustomerDao;
import com.tectoro.mvc.dao.SuperAdminDao;
import com.tectoro.mvc.entity.Admin;
import com.tectoro.mvc.entity.Customer;
import com.tectoro.mvc.entity.SuperAdmin;

@Component
public class DataBaseSeeder {
	
	private static final Logger logger = LoggerFactory.getLogger(DataBaseSeeder.class);
	
	@Autowired
	private SuperAdminDao superAdminDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@EventListener
	public void populateDatabase(final ContextRefreshedEvent cfe)	{
		logger.info("**************** Start of DataBaseSeeder.populateDatabase *****************");
		populateSuperAdminTable();
		populateAdminTable();
		populateCustomerTable();
		logger.info("**************** End of DataBaseSeeder.populateDatabase *****************");
	}
	
	public void populateSuperAdminTable()	{
		logger.info("*********** Start of DataBaseSeeder.populateSuperAdminTable **********");
		List<SuperAdmin> superAdminsList = superAdminDao.getAllSuperAdmins();
		if(CollectionUtils.isEmpty(superAdminsList))	{
			SuperAdmin superAdmin = new SuperAdmin();
			superAdmin.setCreatedDate(System.currentTimeMillis());
			superAdmin.setEmailId("superadmin1@gmail.com");
			superAdmin.setIsActiveUser((byte)1);
			superAdmin.setMobileNumber("9848022338");
			superAdmin.setSuperAdminName("superadmin");
			superAdmin.setUserName("superadmin1");
			superAdmin.setPassword(passwordEncoder.encode("123"));
			superAdminDao.saveOrUpdateSuperAdmin(superAdmin);
			logger.info("*********** Start of DataBaseSeeder.populateSuperAdminTable **********");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void populateAdminTable()	{
		logger.info("*********** Start of DataBaseSeeder.populateAdminTable **********");
		List<Admin> adminList = adminDao.getAllAdmins();
		if(CollectionUtils.isEmpty(adminList))	{
			Admin admin = new Admin();
			admin.setAddress("admin address");
			admin.setAge(24);
			admin.setDateOfBirth(new Date(1996, 5, 31));
			admin.setEmailId("admin1@gmail.com");
			admin.setCreatedDate(System.currentTimeMillis());
			admin.setFirstName("first admin");
			admin.setLastName("last admin");
			admin.setGender(GenderEnum.MALE);
			admin.setIsActiveUser((byte)1);
			admin.setMobileNumber("9848022338");
			admin.setUserName("admin1");
			admin.setPassword(passwordEncoder.encode("123")); // to be encrypted
			admin.setModifiedDate(System.currentTimeMillis());
			admin.setAge(24);
			adminDao.saveOrUpdateAdmin(admin);
			logger.info("*********** End of DataBaseSeeder.populateAdminTable **********");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void populateCustomerTable()	{
		logger.info("*********** End of DataBaseSeeder.populateCustomerTable **********");
		List<Customer> customerList = customerDao.getAllCustomers();
		if(CollectionUtils.isEmpty(customerList))	{
			Customer customer = new Customer();
			customer.setAddress("customer address");
			customer.setAge(24);
			customer.setCreatedDate(System.currentTimeMillis());
			customer.setDateOfBirth(new Date(1996, 5, 31));
			customer.setEmailId("customer1@gmail.com");
			customer.setFirstName("first customer");
			customer.setGender(GenderEnum.MALE);
			customer.setIsActiveUser((byte)1);
			customer.setIscreatedFromAdminJourney((byte)0);
			customer.setIscreatedFromCustomerJourney((byte)1);
			customer.setLastName("last customer");
			customer.setMobileNumber("9848022338");
			customer.setModifiedDate(System.currentTimeMillis());
			customer.setPassword(passwordEncoder.encode("123")); // to be encrypted
			customer.setUserName("customer1");
			customerDao.saveCustomer(customer);
		}
		logger.info("*********** End of DataBaseSeeder.populateCustomerTable **********");
	}
}
