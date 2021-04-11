package com.tectoro.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tectoro.mvc.dto.ApiRequestDto;
import com.tectoro.mvc.dto.ApiResponse;

@Controller
@RequestMapping(value = "/superadmin/")
public class SuperAdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(SuperAdminController.class);
	
	@Value("${superadmin.folder.path}")
	private String folderPath;
	
	@RequestMapping(value = "home",method = RequestMethod.GET)
	public String getSuperAdminDashBoard()	{
		logger.info("*************** Start of SuperAdminController.getSuperAdminDashBoard ***************");
		return "redirect:create-admin";
	}
	
	@RequestMapping(value = "create-admin",method = RequestMethod.GET)
	public ModelAndView createAdmin()	{
		ModelAndView mav = new ModelAndView(folderPath + "createAdmin");
		return mav;
	}
	
	@RequestMapping(value = "validate-admin-email",method = RequestMethod.POST)
	 public @ResponseBody ApiResponse validateAdminEmail(@RequestBody ApiRequestDto request)	{
		logger.info("request---------------------> {}",request);
		ApiResponse response = new ApiResponse();
		response.setStatusCode(500);
		response.setErrorMessage("An account with this email already exists");
		return response;
	}
}
