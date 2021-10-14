package com.revature.project1;

import com.revature.project1.daos.DBConnection;
import com.revature.project1.daos.ReimbursementDaoImpl;
import com.revature.project1.daos.UserDaoImpl;
import com.revature.project1.services.ReimbursementService;
import com.revature.project1.services.UserService;

public class ServiceLoader {
	private DBConnection con = new DBConnection();
	
	private UserDaoImpl uDao = new UserDaoImpl(con);
	private ReimbursementDaoImpl reimbDao = new ReimbursementDaoImpl(con);
	
	
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
