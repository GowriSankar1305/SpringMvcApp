package com.tectoro.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public ModelAndView home()	{
		return new ModelAndView("index", "message", " It is spring mvc Application");
	}
}
