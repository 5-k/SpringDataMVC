package com.prateek.springservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.springservice.entity.User;
/**
 * @author prateek.mishra
 * Repository Interface for CRUD operations on User Table
 */
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailIgnoreCase(String email); 
}
