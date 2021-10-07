package com.revature.project1.models;

public class ReimbType {
	private int reimbTypeId;
	private String reimbTypeName;
	
	public ReimbType() {
	}
	
	public ReimbType(int reimbTypeId, String reimbTypeName) {
		this.reimbTypeId = reimbTypeId;
		this.reimbTypeName = reimbTypeName;
	}

	public String getReimbTypeName() {
		return reimbTypeName;
	}

	public void setReimbTypeName(String reimbTypeName) {
		this.reimbTypeName = reimbTypeName;
	}

	public int getReimbTypeId() {
		return reimbTypeId;
	}

	@Override
	public String toString() {
		return "ReimbType [reimbTypeId=" + reimbTypeId + ", reimbTypeName=" + reimbTypeName + "]";
	}
	
	
}
