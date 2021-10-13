package com.revature.project1.daos;

import java.util.List;

import com.revature.project1.models.User;

public interface UserDao extends GenericDao<User>{
	List<User> getUserListByUserRoleId(int roleId);
}
