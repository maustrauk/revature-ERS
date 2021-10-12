package com.revature.project1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUserServlet extends HttpServlet{
	
	private InsertUserDispatcher iUserDisp = new InsertUserDispatcher();

	public InsertUserServlet() {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		//req.getRequestDispatcher(iUserDisp.process(req)).forward(req, resp);
	}
	

}
