package com.prateek.springservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prateek.springservice.dto.UserDto;
import com.prateek.springservice.exception.ApplicationRuntimeException;
import com.prateek.springservice.service.Service;
import com.prateek.springservice.utility.JsonResponse;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private Service service;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/user/{userId}/profile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  getProfileForUser(@PathVariable Integer userId) {
		log.info("Rest to fetch profile with user id {} ",userId);
		UserDto dto  = service.getUserDto(userId);
		if(null != dto) {
			log.info("User Fetched successfully");
			return new ResponseEntity<UserDto>(dto, HttpStatus.OK);	
		}
		log.info("User not found");
		return new ResponseEntity<JsonResponse>(new JsonResponse("User with userId : " + userId + "does not exists in database"), HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/app/unsecured/signup", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonResponse> signUpNewUser(@RequestBody UserDto user) {
		
		try {
			log.info("Rest for signing up new User");
			String response = service.signUpNewUser(user);
			return new ResponseEntity<JsonResponse>(new JsonResponse(response), HttpStatus.OK);
		} catch (ApplicationRuntimeException e) {
			log.error("ApplicationRuntimeException occurred : {} ",e.getMessage(),e);
			return new ResponseEntity<JsonResponse>(new JsonResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			log.error("Exception occurred : {} ",e.getMessage(),e);
			return new ResponseEntity<JsonResponse>(new JsonResponse("Exception Creating User"), HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/app/unsecured/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  loginValidator(@RequestBody UserDto input) {
		
		try {
			log.info("Rest to validate user");
			UserDto dto = service.isUserCredentialValid(input);
			return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
		} catch (ApplicationRuntimeException e) {
			log.error("ApplicationRuntimeException occurred : {} ",e.getMessage(),e);
			return new ResponseEntity<JsonResponse>(new JsonResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			log.error("Exception occurred : {} ",e.getMessage(),e);
			return new ResponseEntity<JsonResponse>(new JsonResponse("Exception validating User"), HttpStatus.EXPECTATION_FAILED);
		}

	}
}
