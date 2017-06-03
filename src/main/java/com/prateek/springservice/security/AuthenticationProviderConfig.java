package com.prateek.springservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.prateek.springservice.utility.ApplicationProperties;

@Configuration
public class AuthenticationProviderConfig {
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(applicationProperties.getJdbcDriverName());
		driverManagerDataSource.setUrl(applicationProperties.getSpringDataSourceUrl());
		driverManagerDataSource.setUsername(applicationProperties.getDataSourceUserName());
		driverManagerDataSource.setPassword(applicationProperties.getDataSourcePassword());
		return driverManagerDataSource;
	}

	@Bean(name="userDetailsService")
	public UserDetailsService userDetailsService(){
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource());
		jdbcImpl.setUsersByUsernameQuery("select email,password from user_details where username=?");
		return jdbcImpl;	
	}
}