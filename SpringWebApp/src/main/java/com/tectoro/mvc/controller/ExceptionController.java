package com.tectoro.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class ExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(value = MaxUploadSizeExceededException.class)
	@ResponseBody public String handleFileSizeException(MaxUploadSizeExceededException exc
			,HttpServletRequest req,HttpServletResponse res)	{
		logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		String url = "";
		if(null != req.getParameter("adminImage"))	{
			url = req.getContextPath() + "/superadmin/create-admin";
		}
		logger.info("cccccccccccccccccccccccccccccccccccccccccccccccc");
		return "<h2 style='color:red;'>File is too large. "
				+ "file size should not be more than 3MB</h2><a href='"+ url +"'>Go back</a>";
	}
}
