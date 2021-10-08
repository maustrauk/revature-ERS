package com.revature.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.models.User;

public class DirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("inside Direct Servlet, doGet");
		PrintWriter printOut = resp.getWriter();
		printOut.print("<html><body><h1>Servlet Directly Responding</h1></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		resp.setContentType("application/json");
		User testUser = new User("Test", "Test", "Test", "Test", "Test", 1);
		
		resp.getWriter().write(new ObjectMapper().writeValueAsString(testUser));
	} 
	
}
