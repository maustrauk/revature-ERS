package com.revature.project1.models;

public class Role {
	private int roleId;
	private String roleName;
	
	public Role() {
	}
	
	public Role(int roleId, String userRoleName) {
		this.roleId = roleId;
		this.roleName = userRoleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String userRoleName) {
		this.roleName = userRoleName;
	}

	public int getRoleId() {
		return roleId;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
}
