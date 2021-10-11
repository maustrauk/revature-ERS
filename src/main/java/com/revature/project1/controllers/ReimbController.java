package com.revature.project1.controllers;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.LogHelper;
import com.revature.project1.ServiceLoader;
import com.revature.project1.models.Reimbursement;

public class ReimbController {
	private final ServiceLoader sLoader = new ServiceLoader();
	private final LogHelper log = new LogHelper();

	public ReimbController() {
	}
	
	public String addReimb(HttpServletRequest req) {
		System.out.println("In reimbursement controller add");
		if(!req.getMethod().equals("POST")) {
			return "html/sign_in_page.html";
		}
		
		byte[] reimbReceipt;
		
		try {
			reimbReceipt = sLoader.getReimbursementService().getFileStream(req.getParameter("receipt"));
		} catch (Exception e) {
			log.callErrorLogger(e);
			reimbReceipt = new byte[0];
		}
		
		
		Reimbursement newReimb = new Reimbursement();
		newReimb.setReimbAmount(Double.parseDouble(req.getParameter("amount")));
		newReimb.setReimbDescription(req.getParameter("description"));
		newReimb.setReimbAuthor(1);
		newReimb.setReimbReceipt(reimbReceipt);
		newReimb.setReimbStatusId(3);
		newReimb.setReimbTypeId(Integer.parseInt(req.getParameter("reimbType")));
		
		Reimbursement reimb = sLoader.getReimbursementService().addReimbForCheck(newReimb, req.getParameter("username"));
		if(reimb == null) {
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("currentReimb", reimb);
			return "html/home.html";
		}
		
	}
		
		
}
