package com.example.demo.bean;

public class Student {

	private int stu_id;
	private String  stu_name;
	private int  stu_age;
	private Address address;
	
	public Student(int id, String name, int age, Address address) {
		super();
		this.stu_id = id;
		this.stu_name = name;
		this.stu_age = age;
		this.address = address;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return stu_id;
	}
	public void setId(int id) {
		this.stu_id = id;
	}
	public String getName() {
		return stu_name;
	}
	public void setName(String name) {
		this.stu_name = name;
	}
	public int getAge() {
		return stu_age;
	}
	public void setAge(int age) {
		this.stu_age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + stu_id + ", name=" + stu_name + ", age=" + stu_age + ", address=" + address  + "]";
	}
	
	
}
