package com.revature.project1.daos;

import java.util.List;

import com.revature.project1.models.Reimbursement;

public interface ReimbursementDao extends GenericDao<Reimbursement>{
	Reimbursement insertWithoutProof(Reimbursement entity);
	List<Reimbursement> getReimbListByAuthorId(int userId);
}
