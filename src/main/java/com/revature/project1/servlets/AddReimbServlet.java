package com.revature.project1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddReimbServlet extends HttpServlet{
	private AddReimbDispatcher arDisp = new AddReimbDispatcher();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(arDisp.process(req)).forward(req, resp);
	}
	
	
}
