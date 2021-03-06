package com.revature.project1.services;

import java.util.List;

import com.revature.project1.LogHelper;
import com.revature.project1.daos.UserDaoImpl;
import com.revature.project1.models.User;

public class UserService {
	private UserDaoImpl uDao;
	private final LogHelper log = new LogHelper();
	
	public UserService() {
	}

	public UserService(UserDaoImpl uDao) {
		this.uDao = uDao;
	}
	
	public User verifyLoginCredentials(String uName, String uPassword) {
		User user = new User();
		try {
			user = getUserByName(uName);
			if (user.getUserPassword().equals(uPassword)) {
				return user;
			} else {
				log.callErrorLogger("Wrong Password");
				return null;
			}
		} catch (Exception e){
			log.callErrorLogger(e);
			return null;
		}
	}
	
	public List<User> getAllByRoleId(int roleId) {
		List<User> list = uDao.getUserListByUserRoleId(roleId);
		for (User user: list) {
			user.setUserPassword(null);
		}
		return list; 
	}
	
	public List<User> getAllUsers() {
		return uDao.getAll();
	}
	
	public User getUserByName(String name) {
		User user = uDao.getByName(name);
		if (user == null) {
			throw new NullPointerException("There isn't a user with name: " + name);
		}
		return user;
	}
	
	public User getUserById(int id) {
		User user = uDao.getById(id);
		if (user == null) {
			throw new NullPointerException("There isn't a user with id: " + id);
		}
		return user;
	}
	
	public User insertUser(User user) {
		User checkUser = uDao.getByName(user.getUserName());
		
		try {
			if(checkUser.getUserName() != null) {
				throw new NullPointerException("There is user with similar username: " + user.getUserName() + " in DB");
			}
			
			User newUser = uDao.insert(user);
			return newUser;
		} catch (NullPointerException e) {
			log.callErrorLogger(e);
			return null;
		}
		
		
	}
	
	public User updateUser(User user) {
		try {
			if (uDao.getById(user.getUserId()) == null) {
				throw new NullPointerException("There isn't a user with id: " + user.getUserId());
			}
			
			return uDao.update(user);	
		} catch(NullPointerException e) {
			log.callErrorLogger(e);
			return null;
		}
	}
	
	public void deleteUser(User user) {
		if (uDao.getById(user.getUserId()) == null) {
			throw new NullPointerException("There isn't a user with id: " + user.getUserId());
		}
		uDao.delete(user);
	}
	
}
