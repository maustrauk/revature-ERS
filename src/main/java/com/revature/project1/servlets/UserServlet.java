package com.revature.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.JacksonHelper;

public class UserServlet extends HttpServlet{
	private final JacksonHelper jackson = new JacksonHelper();
	private UserDispatcher uDisp = new UserDispatcher();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		String json = jackson.userToJsonString(uDisp.process(req));
		out.print(json);
		out.flush(); 
	}
}
