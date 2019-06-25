package com.foi.springboot.web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userid, String password) {
		//test App
		return userid.equalsIgnoreCase("test123")
				&& password.equalsIgnoreCase("test123");
		
	}

}
