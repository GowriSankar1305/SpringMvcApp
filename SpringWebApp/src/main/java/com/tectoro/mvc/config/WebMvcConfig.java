package com.tectoro.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tectoro.mvc")
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver()	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/admin/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/superadmin/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/customer/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public BCryptPasswordEncoder getPassWordEncoder()	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean("multipartResolver")
	public MultipartResolver getMultipartResolver()	{
		CommonsMultipartResolver multiPartResolver = new CommonsMultipartResolver();
		multiPartResolver.setMaxUploadSize(3145728); //3mb
		//multiPartResolver.setDefaultEncoding("UTF-8");
		return multiPartResolver;
	}
}
