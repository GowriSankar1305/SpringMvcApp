package com.tectoro.mvc.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);
		appContext.register(SecurityConfig.class);
		ServletRegistration.Dynamic  dispatcher = servletContext.addServlet(
				"dispatcher",new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		FilterRegistration.Dynamic filter = servletContext.addFilter(
				"springSecurityFilterChain", new DelegatingFilterProxy());
		filter.addMappingForUrlPatterns(null, false, "/*");
	}
}
