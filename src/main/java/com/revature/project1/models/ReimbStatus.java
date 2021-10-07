package com.revature.project1.models;

public class ReimbStatus {
	private int reimbStatusId;
	private String reimbStatusName;
	
	public ReimbStatus() {
	}
	
	public ReimbStatus(int reimbStatusId, String reimbStatusName) {
		this.reimbStatusId = reimbStatusId;
		this.reimbStatusName = reimbStatusName;
	}

	public String getReimbStatusName() {
		return reimbStatusName;
	}

	public void setReimbStatusName(String reimbStatusName) {
		this.reimbStatusName = reimbStatusName;
	}

	public int getReimbStatusId() {
		return reimbStatusId;
	}

	@Override
	public String toString() {
		return "ReimbStatus [reimStatusId=" + reimbStatusId + ", reimbStatusName=" + reimbStatusName + "]";
	}
	
}
