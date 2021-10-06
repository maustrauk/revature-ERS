package com.revature.project1.models;

public class UsereRole {
	private int userRoleId;
	private String userRoleName;
	
	public UsereRole() {
	}
	
	public UsereRole(int userRoleId, String userRoleName) {
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	@Override
	public String toString() {
		return "UserRole id is: " + this.userRoleId + " , UserRole name is: " + this.userRoleName;
	}
	
	
}
