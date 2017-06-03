package com.prateek.springservice.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.prateek.springservice.dto.UserDto;
import com.prateek.springservice.entity.User;
import com.prateek.springservice.exception.ApplicationRuntimeException;
import com.prateek.springservice.repo.UserRepository;
import com.prateek.springservice.utility.ApplicationUtility;

/**
 * @author prateek.mishra
 * Service class performaing actual CRUD operations
 */
@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private UserRepository userRepo;
	
	public String signUpNewUser(UserDto dto) {
		User user = userRepo.findByEmailIgnoreCase(dto.getEmail());
		if(null != user) {
			throw new ApplicationRuntimeException("User with email id : ",dto.getEmail()," already exists in database.");
		}
		
		user = new User(dto.getName(), dto.getCompanyName(), dto.getEmail());
		user.setPassword(ApplicationUtility.getMD5EncryptedPassword(dto.getPassword()));
		userRepo.save(user);
		
		return "Successfully Created user";
	}

	public UserDto isUserCredentialValid(UserDto input) {
		if(null == input) {
			throw new ApplicationRuntimeException("Input cannot be null");
		}
		
		String email = input.getEmail();
		String password = input.getPassword();
		
		if(StringUtils.isEmpty(email)) {
			throw new ApplicationRuntimeException("Email address cannot be null");
		} else if(StringUtils.isEmpty(password)) {
			throw new ApplicationRuntimeException("Password cannot be null");
		}
		
		User user = userRepo.findByEmailIgnoreCase(email);
		if(null == user) {
			throw new ApplicationRuntimeException("User with user email id : " , email, " does not exists in database.");
		}
		
		if(user.getPassword().equalsIgnoreCase(ApplicationUtility.getMD5EncryptedPassword(password))) {
			return getUserDto(user);
		} 
		
		throw new ApplicationRuntimeException("Invalid Password for user with user email id : " , email);
	}
	
	public UserDto getUserDto(Integer userId) {
		if(null == userId) {
			return null;
		}
		User user = userRepo.findOne(userId);
		if(null == user) {
			return null;
		}
		return getDto(user);
	}
	
	public UserDto getUserDto(User user) {
		if(null == user) {
			return null;
		}
		return getDto(user);
	}

	private UserDto getDto(User user) {
		return new UserDto()
				.withId(user.getId())
				.withName(user.getName())
				.withCompanyName(user.getCompanyName())
				.withEmail(user.getEmail());

	}
}
