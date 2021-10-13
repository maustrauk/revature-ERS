package com.revature.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.JacksonHelper;

public class ListServlet extends HttpServlet{
	private final JacksonHelper jackson = new JacksonHelper();
	private ListDispatcher lDisp = new ListDispatcher();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		String json = jackson.toJsonString(lDisp.process(req));
		if (json != null) {
			out.print(json);
		} else {
			out.print("Wrong credentials");
		}
		out.flush(); 
	}

}
