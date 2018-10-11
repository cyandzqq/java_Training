package com.example.demo.bean;

public class Address {

	private int add_id;
	private String add_name;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int add_id, String add_name) {
		super();
		this.add_id = add_id;
		this.add_name = add_name;
	}
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public String getAdd_name() {
		return add_name;
	}
	public void setAdd_name(String add_name) {
		this.add_name = add_name;
	}
	@Override
	public String toString() {
		return "Address [add_id=" + add_id + ", add_name=" + add_name + "]";
	}
	
	
	
}
