package com.prateek.springservice.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @author prateek.mishra
 * Dto class for data transfer
 * Builder Pattern used
 */
public class UserDto implements Serializable {

	private static final long serialVersionUID = 6669303311756425027L;

	private int id;
	
	@NotBlank private String name;
	@NotBlank private String companyName;
	@NotBlank private String email;
	@NotBlank @JsonInclude(Include.NON_NULL) private String password;

	public int getId() {
		return id;
	}

	public UserDto withId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserDto withName(String name) {
		this.name = name;
		return this;
	}

	public String getCompanyName() {
		return companyName;
	}

	public UserDto withCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserDto withEmail(String email) {
		this.email = email;		
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserDto withPassword(String password) {
		this.password = password;
		return this;
	}	
}
