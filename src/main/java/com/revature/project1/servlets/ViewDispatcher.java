package com.revature.project1.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.UserController;

public class ViewDispatcher {
	private UserController uCont = new UserController();
	
	public ViewDispatcher() {
		// TODO Auto-generated constructor stub
	}

	public String process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/project1/login.change":
			System.out.println("in login.change dispatcher");
			return uCont.login(req);
		default:
			System.out.println("in default");
			return "html/sign_in_page.html";
		}
	}
}
