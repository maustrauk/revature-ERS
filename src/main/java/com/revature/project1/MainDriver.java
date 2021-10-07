package com.revature.project1;

import com.revature.project1.models.ReimbStatus;
import com.revature.project1.models.ReimbType;
import com.revature.project1.models.Role;

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
	}
}
