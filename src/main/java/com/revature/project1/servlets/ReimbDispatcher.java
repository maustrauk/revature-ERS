package com.revature.project1.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.ReimbController;
import com.revature.project1.models.Reimbursement;

public class ReimbDispatcher {
	private ReimbController rCont = new ReimbController();

	public ReimbDispatcher() {
	}
	
//	public Reimbursement process(HttpServletRequest req) {
//		switch(req.getRequestURI()) {
//		case "/project1/by-user-id.reimb":
//			System.out.println("in by-user-id.reimb dispatcher");
//			return rCont.getReimbByUserId(req);
//		default:
//			System.out.println("in default");
//			return null;
//		}
//	}
}
