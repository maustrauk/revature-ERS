package com.revature.project1.servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.controllers.ReimbController;
import com.revature.project1.models.Reimbursement;

public class ReimbListDispatcher {
	private ReimbController rCont = new ReimbController();
	
	public List<Reimbursement> process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
			case "/project1/by-user-id.reimb-list":
				System.out.println("in by-user-id.reimb-list dispatcher");
				return rCont.getReimbByUserId(req);
			case "/project1/add.reimb-list":
				System.out.println("in add.reimb-list dispatcher");
				return rCont.addReimb(req);
			case "/project1/by-manager-id.reimb-list":
				System.out.println("in by-manager-id.reimb-list dispatcher");
				return rCont.getReimbByManagerId(req);
			case "/project1/update.reimb-list":
				System.out.println("in update.reimb-list dispatcher");
				return rCont.updateReimb(req);
			default:
				System.out.println("in default");
				return null;
		}
	}
}
