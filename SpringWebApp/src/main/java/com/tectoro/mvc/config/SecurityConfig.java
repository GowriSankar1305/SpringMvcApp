package com.tectoro.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tectoro.mvc.enums.RoleEnum;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] ALLOWED_URLS = {"/","/login/","/login","/resources/**"};

	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(ALLOWED_URLS).permitAll()
		.antMatchers("/superadmin/**").hasRole(RoleEnum.SUPERADMIN.name())
		.antMatchers("/admin/**").hasAnyRole(RoleEnum.SUPERADMIN.name(),RoleEnum.ADMIN.name())
		.antMatchers("/customer/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.CUSTOMER.name())
		.antMatchers("/**").authenticated().and()
		.formLogin().loginPage("/login").successHandler(successHandler)
		.failureUrl("/login?login-fail");
		
		http.logout().logoutSuccessUrl("/login?logout-success")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID");
		
		http.sessionManagement().invalidSessionUrl("/login?session-invalid")
		.maximumSessions(1).expiredUrl("/login?session-expired");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
}
