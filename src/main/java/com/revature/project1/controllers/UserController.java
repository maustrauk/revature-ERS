package com.revature.project1.controllers;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.ServiceLoader;
import com.revature.project1.models.User;

public class UserController {
	private final ServiceLoader sLoader = new ServiceLoader();
	
	public UserController() {
	}

	public String login(HttpServletRequest req) {
		System.out.println("In user controller login");
		if(!req.getMethod().equals("POST")) {
			return "html/sign_in_page.html";
		}
		
		User user = sLoader.getUserService().verifyLoginCredentials(req.getParameter("username"), req.getParameter("password"));
		if (user == null) {
			System.out.println("Wrong creds");
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("currentUser", user);
			return "html/home.html";
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
