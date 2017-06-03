package com.prateek.springservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Tried implementing using spring security, using default login box.
 * But was unable to send the crsf token for authenticated users.
 * Hence removed the security.		
 */

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 String[] patterns = new String[] {
			        "/",
			        "/app/login",
			        "/app/unsecured",
			        "/app/signup",
			        "/index.html",
			        "/home.html",
			        "/login.html",
			        "/signup.html"
			    };
		 
		http.authorizeRequests()
			.antMatchers(patterns).permitAll()
			.antMatchers("/app/unsecured/login").permitAll()
			.antMatchers("/app/unsecured/signup").permitAll()
			.antMatchers("/app/secured/**").authenticated()
			.and()
			.logout()
			.logoutSuccessUrl("/app/unsecured/logout")
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
			.csrf()
			.disable()
			;
	}

	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder(){
		return new BCryptPasswordEncoder();
	}
}