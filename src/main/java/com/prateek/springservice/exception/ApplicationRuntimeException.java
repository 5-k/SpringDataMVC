package com.prateek.springservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author prateek.mishra
 * Custom exception class for easier manipulations
 */
public class ApplicationRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -2279032832974179060L;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public ApplicationRuntimeException() {
		super();
		log.info("ApplicationRuntimeException occurred");
	}
	
	public ApplicationRuntimeException(String... arrayOfString) {
		StringBuilder builder = new StringBuilder();
		if(null != arrayOfString) {
			for(String string : arrayOfString) {
				builder.append(string);
			}
		}
		throw new ApplicationRuntimeException(builder.toString());
	}
	
	public ApplicationRuntimeException(String message) {
		super(message);
		
		if(null != message)
			log.error("ApplicationRuntimeException with message {} " ,message);
	}
	
}
