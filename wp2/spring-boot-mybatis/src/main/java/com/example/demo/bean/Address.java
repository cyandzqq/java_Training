package com.example.demo.bean;

public class Address {

	private int addId;
	private String addName;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int addId, String addName) {
		super();
		this.addId = addId;
		this.addName = addName;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getAddName() {
		return addName;
	}
	public void setAddName(String addName) {
		this.addName = addName;
	}
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", addName=" + addName + "]";
	}
	
	
}
