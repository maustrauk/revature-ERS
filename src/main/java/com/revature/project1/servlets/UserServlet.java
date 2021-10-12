package com.revature.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.models.User;

public class UserServlet extends HttpServlet{
	private UserDispatcher uDisp = new UserDispatcher();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User result = uDisp.process(req);
		
		 ObjectMapper Obj = new ObjectMapper();
		
		String objectJsonString = Obj.writeValueAsString(result);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		if (result != null) {
			out.print(objectJsonString);
		} else {
			out.print("Wrong credentials");
		}
		
		out.flush(); 
	}

}
