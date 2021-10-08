package com.revature.project1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.models.User;

public class SessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("In session servlet get");
		User testUser = new User("Test_2", "Test_2", "Test_2", "Test_2", "Test_2", 2);
		
		HttpSession session = req.getSession();
		session.setAttribute("currentUser", testUser);
		resp.sendRedirect("html/index.html");		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		System.out.println("In session servlet post");
		
		HttpSession session = req.getSession();
		User testUser = (User)session.getAttribute("currentUser");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(testUser));
	}

}
