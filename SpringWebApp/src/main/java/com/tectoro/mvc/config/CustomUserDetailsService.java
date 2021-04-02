package com.tectoro.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tectoro.mvc.dao.AdminDao;
import com.tectoro.mvc.dao.CustomerDao;
import com.tectoro.mvc.dao.SuperAdminDao;
import com.tectoro.mvc.entity.Admin;
import com.tectoro.mvc.entity.Customer;
import com.tectoro.mvc.entity.SuperAdmin;
import com.tectoro.mvc.enums.RoleEnum;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private SuperAdminDao superAdminDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("****************** Start of CustomUserDetailsService.loadUserByUsername ****************");
		SuperAdmin superAdmin = superAdminDao.getSuperAdminByUserName(username);
		Admin admin = null;
		Customer customer = null;
		if(superAdmin != null)	{
			logger.info("<------------------user is superadmin----------------->");
			User user = new User();
			user.setAccountNonExpired(true);
			user.setAccountNonLocked(true);
			user.setCredentialsNonExpired(true);
			user.setEnabled(true);
			user.setPassword(superAdmin.getPassword());
			user.setUserName(superAdmin.getUserName());
			user.setRole(RoleEnum.ROLE_SUPERADMIN);
			logger.info("****************** End of CustomUserDetailsService.loadUserByUsername ****************");
			return new CustomUserDetails(user);
		}
		else	{
			admin = adminDao.getAdminByUserName(username);
			if(admin != null)	{
				logger.info("<------------------user is admin----------------->");
				User user = new User();
				user.setAccountNonExpired(true);
				user.setAccountNonLocked(true);
				user.setCredentialsNonExpired(true);
				user.setEnabled(true);
				user.setPassword(admin.getPassword());
				user.setUserName(admin.getUserName());
				user.setRole(RoleEnum.ROLE_ADMIN);
				logger.info("****************** End of CustomUserDetailsService.loadUserByUsername ****************");
				return new CustomUserDetails(user);
			}
			else	{
				customer = customerDao.getCustomerByUserName(username);
				if(customer != null)	{
					logger.info("<------------------user is customer----------------->");
					User user = new User();
					user.setAccountNonExpired(true);
					user.setAccountNonLocked(true);
					user.setCredentialsNonExpired(true);
					user.setEnabled(true);
					user.setPassword(customer.getPassword());
					user.setUserName(customer.getUserName());
					user.setRole(RoleEnum.ROLE_CUSTOMER);
					logger.info("****************** End of CustomUserDetailsService.loadUserByUsername ****************");
					return new CustomUserDetails(user);
				}
				else	{
					logger.info("****************** End of CustomUserDetailsService.loadUserByUsername ****************");
					throw new UsernameNotFoundException("User not found with username: "+username);
				}
			}
		}
	}
}
