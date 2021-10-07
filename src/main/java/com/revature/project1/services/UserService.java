package com.revature.project1.services;

import java.util.List;

import com.revature.project1.daos.UserDaoImpl;
import com.revature.project1.models.User;

public class UserService {
	private UserDaoImpl uDao;
	
	public UserService() {
	}

	public UserService(UserDaoImpl uDao) {
		this.uDao = uDao;
	}
	
	public List<User> getAllRoles() {
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
		
		if(checkUser.getUserName() != null) {
			throw new NullPointerException("There is user with similar username: " + user.getUserName() + " in DB");
		}
		
		User newUser = uDao.insert(user);
		
		
		return newUser;
	}
	
	public User updateUser(User user) {
		if (uDao.getById(user.getUserId()) == null) {
			throw new NullPointerException("There isn't a user with id: " + user.getUserId());
		}
		
		if (uDao.getByName(user.getUserName()).getUserId() != 0) {
			throw new NullPointerException("There is a user with username: " + user.getUserName());
		}
		User updatedUser = uDao.update(user);
		
		return updatedUser;
	}
	
	public void deleteUser(User user) {
		if (uDao.getById(user.getUserId()) == null) {
			throw new NullPointerException("There isn't a user with id: " + user.getUserId());
		}
		uDao.delete(user);
	}
	
}
