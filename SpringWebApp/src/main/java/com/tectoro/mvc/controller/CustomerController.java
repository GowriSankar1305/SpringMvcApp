package com.tectoro.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	@RequestMapping(value = "home",method = RequestMethod.GET)
	public ModelAndView home()	{
		return new ModelAndView("customer/home");
	}
}
