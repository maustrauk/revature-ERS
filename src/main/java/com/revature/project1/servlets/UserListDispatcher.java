package com.revature.project1.servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.UserController;
import com.revature.project1.models.User;

public class UserListDispatcher {
	private UserController uCont = new UserController();
	
	public List<User> process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/project1/empl.user-list":
			System.out.println("in empl.user-list dispatcher");
			return uCont.getEmplList(req);
		default:
			System.out.println("in default");
			return null;
	}
	}
}
