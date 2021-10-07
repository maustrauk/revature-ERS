package com.revature.project1;

import com.revature.project1.daos.DBConnection;
import com.revature.project1.daos.ReimbStatusDaoImpl;
import com.revature.project1.daos.ReimbTypeDaoImpl;
import com.revature.project1.daos.ReimbursementDaoImpl;
import com.revature.project1.daos.RoleDaoImpl;
import com.revature.project1.daos.UserDaoImpl;
import com.revature.project1.services.ReimbStatusService;
import com.revature.project1.services.ReimbTypeService;
import com.revature.project1.services.ReimbursementService;
import com.revature.project1.services.RoleService;
import com.revature.project1.services.UserService;

public class ServiceLoader {
	private DBConnection con = new DBConnection();
	
	private RoleDaoImpl rDao = new RoleDaoImpl(con);
	private ReimbTypeDaoImpl reimbTypeDao = new ReimbTypeDaoImpl(con);
	private ReimbStatusDaoImpl reimbStatusDao = new ReimbStatusDaoImpl(con);
	private UserDaoImpl uDao = new UserDaoImpl(con);
	private ReimbursementDaoImpl reimbDao = new ReimbursementDaoImpl(con);
	
	public RoleService getRoleService() {
		return new RoleService(rDao);
	}
	
	public ReimbTypeService getReimbTypeService() {
		return new ReimbTypeService(reimbTypeDao);
	}
	
	public ReimbStatusService getReimbStatusService() {
		return new ReimbStatusService(reimbStatusDao);
	}
	
	public UserService getUserService() {
		return new UserService(uDao);
	}
	
	public ReimbursementService getReimbursementService() {
		return new ReimbursementService(reimbDao);
	}
	
	public DBConnection  getConnection() {
		return con;
	}
	
}
