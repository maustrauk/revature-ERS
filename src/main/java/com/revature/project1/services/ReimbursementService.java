package com.revature.project1.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.revature.project1.LogHelper;
import com.revature.project1.daos.ReimbursementDaoImpl;
import com.revature.project1.daos.UserDaoImpl;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.User;

public class ReimbursementService {
	private final LogHelper log = new LogHelper();
	private ReimbursementDaoImpl reimbDao;
	private UserDaoImpl uDao;
	
	public ReimbursementService() {
	}

	public ReimbursementService(ReimbursementDaoImpl reimbDao) {
		this.reimbDao = reimbDao;
	}
	
	public ReimbursementService(ReimbursementDaoImpl reimbDao, UserDaoImpl uDao) {
		this.reimbDao = reimbDao;
		this.uDao = uDao;
	}
	
	public List<Reimbursement> getAllReimbursements() {
		return reimbDao.getAll();
	}
	
	public Reimbursement addReimbForCheck (Reimbursement reimbursement, String managerName) {
		User manager = new User();
		try {
			manager = uDao.getByName(managerName);
			if (manager != null && manager.getUserRoleId() == 2) {
				reimbursement.setReimbResolver(manager.getUserId());
				return insertReimbursement(reimbursement);
			} else {
				log.callErrorLogger("Wrong Manager Name");
				return null;
			}
		}	catch (Exception e){
			log.callErrorLogger(e);
			return null;
		}
	}
	
	public byte[] getFileStream (String path) throws IOException, FileNotFoundException {
		String updPath = "C:\\FileTest\\" + path;
		File file = new File(updPath);
		System.out.println("File loaded");
		byte[] receipt = new byte[(int)file.length()];
		FileInputStream fis = new FileInputStream(file);
		System.out.println("Stream started");
		int bytesRead = fis.read(receipt);
		while (bytesRead != -1) {
			bytesRead = fis.read(receipt);
		}
		fis.close();
		return receipt;
	}
	
	public Reimbursement insertReimbursement(Reimbursement reimbursement) {
		
		Reimbursement newReimbursement = reimbDao.insert(reimbursement);
		return newReimbursement;
	}
	
	public Reimbursement insertReimbursementWithoutProof(Reimbursement reimbursement) {
		
		Reimbursement newReimbursement = reimbDao.insertWithoutProof(reimbursement);
		return newReimbursement;
	}
	
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		if (reimbDao.getById(reimbursement.getReimbId()) == null) {
			throw new NullPointerException("There isn't a reimbursement with id: " + reimbursement.getReimbId());
		}
		
		Reimbursement updatedReimbursement = reimbDao.update(reimbursement);
		
		return updatedReimbursement;
	}
	
	public void deleteReimbursement(Reimbursement reimbursement) {
		if (reimbDao.getById(reimbursement.getReimbId()) == null) {
			throw new NullPointerException("There isn't a user with id: " + reimbursement.getReimbId());
		}
		reimbDao.delete(reimbursement);
	}
}
