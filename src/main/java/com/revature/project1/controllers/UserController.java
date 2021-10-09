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
			return "html/unsuccessfullogin.html";
		}
		
		User user = sLoader.getUserService().verifyLoginCredentials(req.getParameter("username"), req.getParameter("password"));
		if (user == null) {
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("currentUser", user);
			return "html/home.html";
		}
	}
}
