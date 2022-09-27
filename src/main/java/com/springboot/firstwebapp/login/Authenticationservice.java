package com.springboot.firstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class Authenticationservice {
	public boolean authenticate(String Username, String Password) {
		
		boolean isvalidusername=Username.equalsIgnoreCase("in28minutes");
		boolean isvalidpassword=Password.equalsIgnoreCase("123");
		
		return isvalidusername && isvalidpassword;
	}
}
