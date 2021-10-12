package com.revature.project1.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.UserController;
import com.revature.project1.models.User;

public class CheckDispatcher {
	
	private UserController uCont = new UserController();

	
	public User process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		
		case "/project1/user.login.check":
			System.out.println("in user.login.check dispatcher");
			return uCont.login(req);
		case "/project1/user.signup.check":
			System.out.println("in user.signup.check dispatcher");
			return uCont.signup(req);
		default:
			System.out.println("in default");
			return null;
		}
	}
}
