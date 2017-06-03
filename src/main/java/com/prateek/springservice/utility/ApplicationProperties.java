package com.prateek.springservice.utility;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
/**
 * @author prateek.mishra
 * Property Reader for reading application properties
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationProperties {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	private String defaulJdbcDriverName = "com.mysql.jdbc.Driver";
	
	@Value("${spring.datasource.url}")
	private String springDataSourceUrl;

	@Value("${spring.datasource.driverClassName}")
	private String jdbcDriverName;

	@Value("${spring.datasource.username}")
	private String dataSourceUserName;

	@Value("${spring.datasource.password}")
	private String dataSourcePassword;

	public String getSpringDataSourceUrl() {
		return springDataSourceUrl;
	}

	public void setSpringDataSourceUrl(String springDataSourceUrl) {
		this.springDataSourceUrl = springDataSourceUrl;
	}

	public String getJdbcDriverName() {
		if(StringUtils.isBlank(this.jdbcDriverName)) {
			this.jdbcDriverName = defaulJdbcDriverName;
		}
		return jdbcDriverName;
	}

	public void setJdbcDriverName(String jdbcDriverName) {
		this.jdbcDriverName = jdbcDriverName;
	}

	public String getDataSourceUserName() {
		return dataSourceUserName;
	}

	public void setDataSourceUserName(String dataSourceUserName) {
		this.dataSourceUserName = dataSourceUserName;
	}

	public String getDataSourcePassword() {
		return dataSourcePassword;
	}

	public void setDataSourcePassword(String dataSourcePassword) {
		this.dataSourcePassword = dataSourcePassword;
	}

	public String getDefaulJdbcDriverName() {
		return defaulJdbcDriverName;
	}

	public void setDefaulJdbcDriverName(String defaulJdbcDriverName) {
		this.defaulJdbcDriverName = defaulJdbcDriverName;
	}
}
