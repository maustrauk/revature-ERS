package com.revature.project1;

import java.io.File;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.models.ReimbStatus;
import com.revature.project1.models.ReimbType;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Role;
import com.revature.project1.models.User;

public class MainDriver {
	
	private static ServiceLoader sLoader = new ServiceLoader();
	
	public static void main(String[] args) {
		System.out.println("Roles:");
		for (Role r: sLoader.getRoleService().getAllRoles()) {
			System.out.println(r.getRoleName());
		}
		System.out.println("");
		
		System.out.println("Reimbursement types:");
		for (ReimbType reimbType: sLoader.getReimbTypeService().getAllReimbTypes()) {
			System.out.println(reimbType.getReimbTypeName());
		}
		
		System.out.println("");
		
		System.out.println("Reimbursement statuses:");
		for (ReimbStatus reimbStatus: sLoader.getReimbStatusService().getAllReimbStatuses()) {
			System.out.println(reimbStatus.getReimbStatusName());
		}
		
		System.out.println("");
		
		User testUser = new User("Test User", "password", "Test", "Test", "Test@email.com",  1);
		System.out.println("Test user created:");
		System.out.println(testUser);
		
//		System.out.println("Inserting Test user to DB");
//		sLoader.getUserService().insertUser(testUser);
		System.out.println("Users:");
		for (User user: sLoader.getUserService().getAllUsers()) {
			System.out.println(user);
		}
		
		byte[] b = {(byte)123, (byte)112};
			
		Reimbursement testReimb = new Reimbursement(10.225, "desc", b, 1, 1, 1, 1);
		System.out.println("Test reimbursement created:");
		System.out.println(testReimb);
		System.out.println("Inserting reimbursement user to DB");
		sLoader.getReimbursementService().insertReimbursement(testReimb);
		//sLoader.getReimbursementService().insertReimbursementWithoutProof(testReimb);

		
		System.out.println("Reimbursement:");
		for (Reimbursement reimbursement: sLoader.getReimbursementService().getAllReimbursements()) {
			System.out.println(reimbursement);
		}
		
	}
}
