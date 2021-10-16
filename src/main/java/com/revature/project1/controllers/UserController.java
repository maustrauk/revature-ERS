package com.revature.project1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.revature.project1.JacksonHelper;
import com.revature.project1.PasswordEncrypter;
import com.revature.project1.ServiceLoader;
import com.revature.project1.models.User;

public class UserController {
	private final ServiceLoader sLoader = new ServiceLoader();
	private final JacksonHelper jackson = new JacksonHelper();
	private final PasswordEncrypter encryptPass = new PasswordEncrypter();
	
	public UserController() {
	}

	public User login(HttpServletRequest req) {
		System.out.println("In user controller login");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		User parsedUser = jackson.reqJSONtoUser(req);
		
		parsedUser.setUserPassword(encryptPass.generateSecurePassword(parsedUser.getUserPassword(), encryptPass.downloadSalt()));
		
		
		User user = sLoader.getUserService().verifyLoginCredentials(parsedUser.getUserName(), parsedUser.getUserPassword());
		
		if (user == null) {
			System.out.println("Wrong creds");
			return null;
		} else {
			User returnedUser = user;
			returnedUser.setUserPassword(null);
			return returnedUser;
		}
	}
	
	public User signup(HttpServletRequest req) {
		System.out.println("In user controller signup");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		User newUser = jackson.reqJSONtoUser(req);
		
		newUser.setUserPassword(encryptPass.generateSecurePassword(newUser.getUserPassword(), encryptPass.downloadSalt()));
		
		User user = sLoader.getUserService().insertUser(newUser);
		if (user == null) {
			System.out.println("Some error");
			return null;
		} else {
			User returnedUser = user;
			returnedUser.setUserPassword(null);
			return returnedUser;
		}
	}
	
	public List<User> getEmplList(HttpServletRequest req) {
		System.out.println("In user controller getEmplList");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		User reqUser = jackson.reqJSONtoUser(req);
		
		if(reqUser.getUserRoleId() == 2) {
			return sLoader.getUserService().getAllByRoleId(1);
		} else {
			return null;
		}
		
	}
	
	public User edit(HttpServletRequest req) {
		System.out.println("In user controller signup");
		if(!req.getMethod().equals("POST")) {
			return null;
		}
		
		User editUser = jackson.reqJSONtoUser(req);
		
		editUser.setUserPassword(encryptPass.generateSecurePassword(editUser.getUserPassword(), encryptPass.downloadSalt()));
		
		User user = sLoader.getUserService().getUserByName(editUser.getUserName());
		
		if (user == null) {
			System.out.println("Some error");
			return null;
		} else {
			user.setUserFirstName(editUser.getUserFirstName());
			user.setUserLastName(editUser.getUserLastName());
			user.setUserEmail(editUser.getUserEmail());
			user.setUserPassword(editUser.getUserPassword());
			
			User returnedUser = sLoader.getUserService().updateUser(user);
			if (returnedUser == null) {
				System.out.println("Some error");
				return null;
			}
			returnedUser.setUserPassword(null);
			return returnedUser;
		}
	}
	
	
}
