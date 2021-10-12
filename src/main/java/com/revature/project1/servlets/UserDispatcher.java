package com.revature.project1.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.UserController;
import com.revature.project1.models.User;

public class UserDispatcher {
	private UserController uCont = new UserController();
	
	public UserDispatcher() {
	}

	public User process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/project1/login.user":
			System.out.println("in login.user dispatcher");
			return uCont.login(req);
		case "/project1/signup.user":
			System.out.println("in signup.user dispatcher");
			return uCont.signup(req);
		default:
			System.out.println("in default");
			return null;
		}
	}
}
