package com.revature.project1.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.UserController;

public class InsertUserDispatcher {
	private UserController uCont = new UserController();
	
//	public String process(HttpServletRequest req) {
//		switch(req.getRequestURI()) {
//		case "/project1/login.signUp":
//			System.out.println("in login.signUp dispatcher");
//			return uCont.signup(req);
//		default:
//			System.out.println("in default");
//			return "html/sign_in_page.html";
//		}
//	}
}
