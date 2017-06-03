package com.prateek.springservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author prateek.mishra
 * Spring Boot Application Main
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@PropertySource("application.properties")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);			
	}
}