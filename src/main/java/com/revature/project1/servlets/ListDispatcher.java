package com.revature.project1.servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.ReimbController;
import com.revature.project1.models.Reimbursement;

public class ListDispatcher {
	private ReimbController rCont = new ReimbController();
	
	public List<Reimbursement> process(HttpServletRequest req) {
switch(req.getRequestURI()) {
		
		case "/project1/reimb.by-user.list":
			System.out.println("in reimb.by-user.list dispatcher");
			return rCont.getReimbByUserId(req);
		case "/project1/reimb.add.list":
			System.out.println("in reimb.add.list dispatcher");
			return rCont.addReimb(req);
		default:
			System.out.println("in default");
			return null;
		}
	}
}
