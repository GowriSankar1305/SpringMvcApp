package com.tectoro.mvc.config;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tectoro.mvc.utils.RoleEnum;

@Configuration
@EnableWebSecurity*/
public class SecurityConfigOld	{
	
	/*private static final String[] ALLOWED_URLS = {"/","/admin/","/admin/resources/**","/admin/login-fail","/admin/logout-success","/admin/session-expired",
			"/admin/session-invalid","/superadmin/","/superadmin/resources/**","/superadmin/login-fail","/superadmin/logout-success",
			"/superadmin/session-expired","/superadmin/session-invalid","/customer/","/customer/resources/**","/customer/login-fail",
			"/customer/logout-success","/customer/session-expired","/customer/session-invalid"};
	@Configuration
	@Order(1)
	public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private AdminDetailsService userDetailsService;
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers(ALLOWED_URLS).permitAll()
			.antMatchers("/admin/**").hasRole(RoleEnum.ADMIN.name())
			.antMatchers("/**").denyAll()
			.anyRequest().authenticated().and()
			.formLogin().loginPage("/admin/").defaultSuccessUrl("/admin/home")
			.failureUrl("/admin/login-fail").and().logout().logoutSuccessUrl("/admin/logout-success")
			.clearAuthentication(true).deleteCookies("JSESSIONID")
			.invalidateHttpSession(true).and().sessionManagement().invalidSessionUrl("/admin/session-invalid")
			.maximumSessions(1).expiredUrl("/admin/session-expired");
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		}
	}
	
	
	@Configuration
	@Order(2)
	public class SuperAdminSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private SuperAdminDetailsService userDetailsService;
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers(ALLOWED_URLS).permitAll()
			.antMatchers("/superadmin/**").hasRole(RoleEnum.SUPERADMIN.name())
			.antMatchers("/**").denyAll()
			.anyRequest().authenticated().and()
			.formLogin().loginPage("/superadmin/").defaultSuccessUrl("/superadmin/home")
			.failureUrl("/superadmin/login-fail").and().logout().logoutSuccessUrl("/superadmin/logout-success")
			.clearAuthentication(true).deleteCookies("JSESSIONID")
			.invalidateHttpSession(true).and().sessionManagement().invalidSessionUrl("/superadmin/session-expired")
			.maximumSessions(1).expiredUrl("/superadmin/session-expired");
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		}
	}
	
	
	@Configuration
	@Order(3)
	public class CustomerSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private CustomerDetailsService userDetailsService;
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers(ALLOWED_URLS).permitAll()
			.antMatchers("/customer/**").hasRole(RoleEnum.CUSTOMER.name())
			.antMatchers("/**").denyAll()
			.anyRequest().authenticated().and()
			.formLogin().loginPage("/customer/").defaultSuccessUrl("/customer/home")
			.failureUrl("/customer/login-fail").and().logout().logoutSuccessUrl("/customer/logout-success")
			.clearAuthentication(true).deleteCookies("JSESSIONID")
			.invalidateHttpSession(true).and().sessionManagement().invalidSessionUrl("/customer/session-expired")
			.maximumSessions(1).expiredUrl("/customer/session-expired");
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		}
	}*/
}


