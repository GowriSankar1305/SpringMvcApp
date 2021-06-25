package com.tectoro.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Value("${admin.folder.path}")
	private String folderPath;
	
	@RequestMapping(value = "home",method = RequestMethod.GET)
	public ModelAndView home()	{
		return new ModelAndView(folderPath + "home", "message", " It is spring mvc Application");
	}
	
	@RequestMapping(value = "create-staff",method = RequestMethod.GET)
	public ModelAndView createStaff()	{
		ModelAndView mav = new ModelAndView(folderPath + "createStaff");
		mav.addObject("message", "xxxxxxxxxxxxxxxxxxxxxxxxxxx");
		return mav;
	}
	
	@RequestMapping(value = "get-designations",method = RequestMethod.GET)
	public ModelAndView getDesignations()	{
		ModelAndView mav = new ModelAndView(folderPath + "designations");
		return mav;
	}
}
