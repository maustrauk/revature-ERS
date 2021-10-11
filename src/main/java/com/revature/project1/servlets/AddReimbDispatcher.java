package com.revature.project1.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.ReimbController;

public class AddReimbDispatcher {
	private ReimbController rCont = new ReimbController();

	public AddReimbDispatcher() {
	}
	
	
	public String process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/project1/login.reimb":
			System.out.println("in login.reimb dispatcher");
			return rCont.addReimb(req);
		default:
			System.out.println("in default");
			return "html/sign_in_page.html";
		}
	}

}
