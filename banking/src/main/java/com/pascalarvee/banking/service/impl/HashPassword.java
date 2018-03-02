/**
 * 
 */
package com.pascalarvee.banking.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author PASCAL
 *
 */
public class HashPassword {
	
	public String getHashPassword(String password){
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String hashedPassword = passwordEncoder.encode(password);
		
		System.out.println(hashedPassword);
		
		return hashedPassword;
	}
}
