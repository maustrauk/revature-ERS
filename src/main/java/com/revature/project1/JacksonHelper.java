package com.revature.project1;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.models.ReimbTemp;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.User;

public class JacksonHelper {
	private final ObjectMapper mapper = new ObjectMapper();
	private final LogHelper log = new LogHelper();

	public JacksonHelper() {
	}
	
	public User reqJSONtoUser (HttpServletRequest req) {
		User parsedUser = new User();
		
		try {
			String jsonStr = req.getReader().lines().collect(Collectors.joining());
			System.out.println(jsonStr);
			parsedUser = mapper.readValue(jsonStr, User.class);
		} catch (IOException e) {
			log.callErrorLogger(e);
			parsedUser = null;
		}
		
		return parsedUser;
	}
	
	public ReimbTemp reqJSONtoReimbTemp (HttpServletRequest req) {
		ReimbTemp tReimb = new ReimbTemp();
		
		try {
			String jsonStr = req.getReader().lines().collect(Collectors.joining());
			System.out.println(jsonStr);
			tReimb = mapper.readValue(jsonStr, ReimbTemp.class);
		} catch (IOException e) {
			log.callErrorLogger(e);
			tReimb = null;
		}
		
		return tReimb;
	}
	
	public String toJsonString(User result) {
		try {
			return mapper.writeValueAsString(result);
		} catch (IOException e) {
			log.callErrorLogger(e);
			return null;
		}
	}
		
	public String toJsonString(List<Reimbursement> result) {
		try {
			return mapper.writeValueAsString(result);
		} catch (IOException e) {
			log.callErrorLogger(e);
			return null;
		}
		
	}
}
