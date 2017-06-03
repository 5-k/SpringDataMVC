package com.prateek.springservice.utility;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * @author prateek.mishra
 * Custom class to send back response in Spring Rest JSON format only.
 * I don't prefer Sending simple text as returns, hence using a wrapper 
 */
public class JsonResponse {

	private String message;

	@JsonCreator
	public JsonResponse(@JsonProperty("message") String message) {
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}
}