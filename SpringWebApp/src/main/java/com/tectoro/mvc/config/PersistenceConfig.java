package com.tectoro.mvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.tectoro.mvc")
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class PersistenceConfig {
	
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String userName;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${hibernate.show_sql}")
	private String showSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String ddlAuto;
	
	@Bean
	public DataSource getDataSource()	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()	{
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
		props.setProperty("hibernate.show_sql", showSql);

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager()	{
		HibernateTransactionManager txnMgr = new HibernateTransactionManager();
		txnMgr.setSessionFactory(getSessionFactory().getObject());
		return txnMgr;
	}
}
