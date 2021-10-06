package com.revature.project1.models;

public class ReimStatus {
	private int reimStatusId;
	private String reimStatusName;
	
	public ReimStatus() {
	}
	
	public ReimStatus(int reimStatusId, String reimStatusName) {
		this.reimStatusId = reimStatusId;
		this.reimStatusName = reimStatusName;
	}

	public String getReimStatusName() {
		return reimStatusName;
	}

	public void setReimStatusName(String reimStatusName) {
		this.reimStatusName = reimStatusName;
	}

	public int getReimStatusId() {
		return reimStatusId;
	}

	@Override
	public String toString() {
		return "ReimStatus [reimStatusId=" + reimStatusId + ", reimStatusName=" + reimStatusName + "]";
	}
	
}
