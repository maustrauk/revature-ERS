package com.revature.project1.services;

import java.util.List;

import com.revature.project1.daos.ReimbStatusDaoImpl;
import com.revature.project1.models.ReimbStatus;

public class ReimbStatusService {
	private ReimbStatusDaoImpl reimbStatusDao;
	
	public ReimbStatusService() {
	}

	public ReimbStatusService(ReimbStatusDaoImpl reimbStatusDao) {
		this.reimbStatusDao = reimbStatusDao;
	}
	
	public List<ReimbStatus> getAllReimbStatuses() {
		return reimbStatusDao.getAll();
	}
	
	public ReimbStatus getReimbStatusByName(String name) {
		ReimbStatus reimbStatus = reimbStatusDao.getByName(name);
		if (reimbStatus == null) {
			throw new NullPointerException("There isn't a status with name: " + name);
		}
		return reimbStatus;
	}
	
	public ReimbStatus getReimbStatusById(int id) {
		ReimbStatus reimbStatus = reimbStatusDao.getById(id);
		if (reimbStatus == null) {
			throw new NullPointerException("There isn't a status with id: " + id);
		}
		return reimbStatus;
	}
}
