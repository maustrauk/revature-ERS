package com.revature.project1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.project1.JacksonHelper;
import com.revature.project1.ServiceLoader;
import com.revature.project1.models.ReimbTemp;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.User;

public class ReimbController {
	private final ServiceLoader sLoader = new ServiceLoader();
	private final JacksonHelper jackson = new JacksonHelper();

	public ReimbController() {
	}
	
	public List<Reimbursement> addReimb(HttpServletRequest req) {
		System.out.println("In reimbursement controller add");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		ReimbTemp rTemp = jackson.reqJSONtoReimbTemp(req);
		
		String managerName = rTemp.getReimbResolver();
		String filePath = rTemp.getReimbReceipt();
		
		byte[] reimbReceipt = sLoader.getReimbursementService().getFileStream(filePath);
		
		Reimbursement newReimb = new Reimbursement();
		newReimb.setReimbAmount(rTemp.getReimbAmount());
		newReimb.setReimbAuthor(rTemp.getReimbAuthor());
		newReimb.setReimbDescription(rTemp.getReimbDescription());
		newReimb.setReimbReceipt(reimbReceipt);
		newReimb.setReimbStatusId(3);
		newReimb.setReimbTypeId(rTemp.getReimbTypeId());
		
		Reimbursement reimb = sLoader.getReimbursementService().addReimbForCheck(newReimb, managerName);
		
		if (reimb == null) {
			return null;
		} else {
			return sLoader.getReimbursementService().getReimbListByUserId(reimb.getReimbAuthor());
		}
		
	}
	
	public List<Reimbursement> getReimbByUserId(HttpServletRequest req) {
		System.out.println("In reimb controller getReimbByUserId");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		User reqUser = jackson.reqJSONtoUser(req);
		
		if (reqUser.getUserRoleId() == 1) {
			return sLoader.getReimbursementService().getReimbListByUserId(reqUser.getUserId());
		} else {
			return null;
		}
	}
		
		
}
