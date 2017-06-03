package com.prateek.springservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Spring Entity Class : auto generate using generate ddl as true, or run the SQL Scripts in resource folder
 * @author prateek.mishra
 *
 */
@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="company_name",nullable=false)
	private String companyName;
	
	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;

	public User(){}
	
	public User(String name, String companyName, String email) {
		super();
		this.name = name;
		this.companyName = companyName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}