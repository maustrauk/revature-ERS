package com.revature.project1.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.JacksonHelper;
import com.revature.project1.LogHelper;
import com.revature.project1.ServiceLoader;
import com.revature.project1.models.User;

public class UserController {
	private final ServiceLoader sLoader = new ServiceLoader();
	private final JacksonHelper jackson = new JacksonHelper();
	
	public UserController() {
	}

	public User login(HttpServletRequest req) {
		System.out.println("In user controller login");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		User parsedUser = jackson.reqJSONtoUser(req);
		
		User user = sLoader.getUserService().verifyLoginCredentials(parsedUser.getUserName(), parsedUser.getUserPassword());
		
		if (user == null) {
			System.out.println("Wrong creds");
			return null;
		} else {
			User returnedUser = user;
			returnedUser.setUserPassword(null);
			return returnedUser;
		}
	}
	
	public User signup(HttpServletRequest req) {
		System.out.println("In user controller signup");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		User newUser = jackson.reqJSONtoUser(req);
		
		User user = sLoader.getUserService().insertUser(newUser);
		if (user == null) {
			System.out.println("Some error");
			return null;
		} else {
			User returnedUser = user;
			returnedUser.setUserPassword(null);
			return returnedUser;
		}
	}
}
