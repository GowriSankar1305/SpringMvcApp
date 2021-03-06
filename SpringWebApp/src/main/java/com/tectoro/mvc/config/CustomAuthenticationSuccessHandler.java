package com.tectoro.mvc.config;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.tectoro.mvc.dao.AdminDao;
import com.tectoro.mvc.dao.CustomerDao;
import com.tectoro.mvc.dao.ImageDao;
import com.tectoro.mvc.dao.SuperAdminDao;
import com.tectoro.mvc.entity.Image;
import com.tectoro.mvc.enums.RoleEnum;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	
	@Autowired
	private SuperAdminDao superAdminDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ImageDao imageDao;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info("**************** Start of CustomAuthenticationSuccessHandler.onAuthenticationSuccess **************");
		Long loggedInUserId = null;
		String redirectUrl = null,roleName = null,userName = null;
		HttpSession httpSession = request.getSession();
		CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
		roleName = user.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList()).get(0);
		userName = user.getUsername();
		logger.info("------------------> roleName {} , userName {}",roleName,userName);
		if(roleName.equals(RoleEnum.ROLE_ADMIN.name()))	{
			String imageName = "avatar1.png";
			loggedInUserId = adminDao.getAdminByUserName(userName).getAdminId();
			Image image = imageDao.getImageByAdminId(loggedInUserId);
			if(null != image)
				imageName = image.getGeneratedFileName();
			httpSession.setAttribute("adminImage", imageName);
			redirectUrl = "/admin/home";
		}
		else if(roleName.equals(RoleEnum.ROLE_SUPERADMIN.name()))	{
			loggedInUserId = superAdminDao.getSuperAdminByUserName(userName).getSuperAdminId();
			redirectUrl = "/superadmin/home";
		}
		else if(roleName.equals(RoleEnum.ROLE_CUSTOMER.name()))	{
			loggedInUserId = customerDao.getCustomerByUserName(userName).getCustomerId();
			redirectUrl = "/customer/home";
		}
		
		httpSession.setAttribute("loggedInUserId", loggedInUserId);
		httpSession.setAttribute("roleName", roleName);
		httpSession.setAttribute("userName", userName);
		httpSession.setMaxInactiveInterval(300);
		logger.info("**************** End of CustomAuthenticationSuccessHandler.onAuthenticationSuccess **************");
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
		//response.sendRedirect(request.getContextPath() + "/get-home");
	}
}
