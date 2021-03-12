package com.tectoro.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/superadmin/")
public class SuperAdminController {
	
	@RequestMapping(value = "welcome")
	public String getWelcomePage()	{
		return "home";
	}
}
