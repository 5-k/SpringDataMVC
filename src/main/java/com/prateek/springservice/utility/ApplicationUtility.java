package com.prateek.springservice.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * @author prateek.mishra
 * Static Utility Methods to convert password to MD5 for storing in backend database
 */
public class ApplicationUtility {

	public static String encyptedPassword(String plainTextPassword){
		return new BCryptPasswordEncoder().encode(plainTextPassword);
	}
	
	 public static String getMD5EncryptedPassword(String plainTextPassword) {         
         MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(plainTextPassword.getBytes(),0,plainTextPassword.length());
	         return String.valueOf(new BigInteger(1,m.digest()).toString(16));
		} catch (NoSuchAlgorithmException e) {
			//Md5 Algo noth Found, Using Spring encyptedPassword
			return encyptedPassword(plainTextPassword);
		}
         
     }
      
}
