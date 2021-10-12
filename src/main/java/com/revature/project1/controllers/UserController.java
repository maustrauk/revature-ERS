package com.revature.project1.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.LogHelper;
import com.revature.project1.ServiceLoader;
import com.revature.project1.models.User;

public class UserController {
	private final ServiceLoader sLoader = new ServiceLoader();
	private final LogHelper log = new LogHelper();
	
	public UserController() {
	}

	public User login(HttpServletRequest req) {
		System.out.println("In user controller login");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		User parsedUser = new User();
		
		try {
			String jsonStr = req.getReader().lines().collect(Collectors.joining());
			System.out.println(jsonStr);
			parsedUser = mapper.readValue(jsonStr, User.class);
		} catch (IOException e) {
			log.callErrorLogger(e);
			parsedUser = null;
		}
		
		
		
		User user = sLoader.getUserService().verifyLoginCredentials(parsedUser.getUserName(), parsedUser.getUserPassword());
		if (user == null) {
			System.out.println("Wrong creds");
			return null;
		} else {
			return user;
		}
	}
	
	public String signUp(HttpServletRequest req) {
		System.out.println("In user controller signIn");
		if(!req.getMethod().equals("POST")) {
			return "html/sign_in_page.html";
		}
		
		User newUser = new User(req.getParameter("username"), req.getParameter("password"), req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("email"), 1);
		
		User user = sLoader.getUserService().insertUser(newUser);
		if (user == null) {
			System.out.println("User exist");
			return "exist.change";
		} else {
			req.getSession().setAttribute("currentUser", user);
			return "html/home.html";
		}
	}
}
