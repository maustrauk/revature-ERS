package com.revature.project1;

import com.revature.project1.daos.DBConnection;
import com.revature.project1.daos.ReimbursementDaoImpl;
import com.revature.project1.daos.RoleDaoImpl;
import com.revature.project1.daos.UserDaoImpl;
import com.revature.project1.services.ReimbursementService;
import com.revature.project1.services.RoleService;
import com.revature.project1.services.UserService;

public class ServiceLoader {
	private DBConnection con = new DBConnection();
	
	private RoleDaoImpl rDao = new RoleDaoImpl(con);
	private UserDaoImpl uDao = new UserDaoImpl(con);
	private ReimbursementDaoImpl reimbDao = new ReimbursementDaoImpl(con);
	
	public RoleService getRoleService() {
		return new RoleService(rDao);
	}
	
	
	public UserService getUserService() {
		return new UserService(uDao);
	}
	
	public ReimbursementService getReimbursementService() {
		return new ReimbursementService(reimbDao, uDao);
	}
	
	public DBConnection  getConnection() {
		return con;
	}
	
}
