package com.tectoro.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {
	
	@Value("${login.fail.message}")
	private String loginFailMessage;
	@Value("${logout.success.message}")
	private String logoutSuccessMessage;
	@Value("${session.expired.message}")
	private String sessionExpireMessage;
	@Value("${session.invalid.message}")
	private String sessionInvalidMessage;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String getWelcomePage(Model model)	{
		model.addAttribute("message", "Welcome to hotel management application");
		return "index";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String getLoginPage(Model model,
			@RequestParam(required = false,name = "login-fail") String loginFail,
			@RequestParam(required = false,name = "logout-success") String logoutSuccess,
			@RequestParam(required = false,name = "session-expired") String sessionExpired,
			@RequestParam(required = false,name = "session-invalid") String sessionInvalid)	{
		
		if(loginFail != null)
			model.addAttribute("loginFail", loginFailMessage);
		if(logoutSuccess != null)
			model.addAttribute("logoutSuccess", logoutSuccessMessage);
		if(sessionExpired != null)
			model.addAttribute("sessionExpired", sessionExpireMessage);
		if(sessionInvalid != null)
			model.addAttribute("sessionInvalid", sessionInvalidMessage);
		return "login";
	}
	
	@RequestMapping(value = "/get-home",method = RequestMethod.GET)
	public String getHomePage()	{
		return "home";
	}
}
