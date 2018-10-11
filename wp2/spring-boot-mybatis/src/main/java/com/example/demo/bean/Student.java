package com.example.demo.bean;

public class Student {

	private int stuId;
	private String  stuName;
	private int  stuAge;
	private int claId;
	private Address address;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int stuId, String stuName, int stuAge, Address address) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.address = address;
	}
	
	public Student(int stuId, String stuName, int stuAge, int claId, Address address) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.claId = claId;
		this.address = address;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getClaId() {
		return claId;
	}
	public void setClaId(int claId) {
		this.claId = claId;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAge=" + stuAge + ", address=" + address + "]";
	}
	
	
	
}
