package com.revature.project1.services;

import java.util.List;

import com.revature.project1.daos.ReimbTypeDaoImpl;
import com.revature.project1.models.ReimbType;

public class ReimbTypeService {
	private ReimbTypeDaoImpl reimbTypeDao ;
	
	public ReimbTypeService() {
	}

	public ReimbTypeService(ReimbTypeDaoImpl reimbTypeDao) {
		this.reimbTypeDao = reimbTypeDao;
	}
	
	public List<ReimbType> getAllRoles() {
		return reimbTypeDao.getAll();
	}
	
	public ReimbType getRoleByName(String name) {
		ReimbType reimbType = reimbTypeDao.getByName(name);
		if (reimbType == null) {
			throw new NullPointerException("There isn't a type with name: " + name);
		}
		return reimbType;
	}
	
	public ReimbType getRoleById(int id) {
		ReimbType reimbType = reimbTypeDao.getById(id);
		if (reimbType == null) {
			throw new NullPointerException("There isn't a type with id: " + id);
		}
		return reimbType;
	}
}
