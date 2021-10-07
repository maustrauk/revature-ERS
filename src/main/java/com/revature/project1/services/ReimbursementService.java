package com.revature.project1.services;

import java.util.List;

import com.revature.project1.daos.ReimbursementDaoImpl;
import com.revature.project1.models.Reimbursement;

public class ReimbursementService {
	private  ReimbursementDaoImpl reimbDao;
	
	public ReimbursementService() {
	}

	public ReimbursementService(ReimbursementDaoImpl reimbDao) {
		this.reimbDao = reimbDao;
	}
	
	public List<Reimbursement> getAllReimbursements() {
		return reimbDao.getAll();
	}
	
	public Reimbursement insertReimbursement(Reimbursement reimbursement) {
		
		Reimbursement newReimbursement = reimbDao.insert(reimbursement);
		
		
		return newReimbursement;
	}
	
	public Reimbursement updateUser(Reimbursement reimbursement) {
		if (reimbDao.getById(reimbursement.getReimbId()) == null) {
			throw new NullPointerException("There isn't a reimbursement with id: " + reimbursement.getReimbId());
		}
		
		Reimbursement updatedReimbursement = reimbDao.update(reimbursement);
		
		return updatedReimbursement;
	}
	
	public void deleteUser(Reimbursement reimbursement) {
		if (reimbDao.getById(reimbursement.getReimbId()) == null) {
			throw new NullPointerException("There isn't a user with id: " + reimbursement.getReimbId());
		}
		reimbDao.delete(reimbursement);
	}
}
