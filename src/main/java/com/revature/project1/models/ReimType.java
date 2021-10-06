package com.revature.project1.models;

public class ReimType {
	private int reimTypeId;
	private String reimTypeName;
	
	public ReimType() {
	}
	
	public ReimType(int reimTypeId, String reimTypeName) {
		this.reimTypeId = reimTypeId;
		this.reimTypeName = reimTypeName;
	}

	public String getReimTypeName() {
		return reimTypeName;
	}

	public void setReimTypeName(String reimTypeName) {
		this.reimTypeName = reimTypeName;
	}

	public int getReimTypeId() {
		return reimTypeId;
	}

	@Override
	public String toString() {
		return "ReimType [reimTypeId=" + reimTypeId + ", reimTypeName=" + reimTypeName + "]";
	}
	
	
}
