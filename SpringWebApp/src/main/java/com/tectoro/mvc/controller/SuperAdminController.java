package com.tectoro.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/superadmin/")
public class SuperAdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(SuperAdminController.class);
	
	@RequestMapping(value = "home",method = RequestMethod.GET)
	public String getSuperAdminDashBoard()	{
		logger.info("*************** Start of SuperAdminController.getSuperAdminDashBoard ***************");
		return "superadmin/dashboard";
	}
	
	@RequestMapping(value = "create-admin",method = RequestMethod.GET)
	public ModelAndView createAdmin()	{
		ModelAndView mav = new ModelAndView("createAdmin");
		return mav;
	}
}
