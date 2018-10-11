package com.example.demo.bean;

import java.util.ArrayList;

public class Class {

	private int claId;
	private String claName;
	private ArrayList<Student> stulist;
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Class(int claId, String claName, ArrayList<Student> stulist) {
		super();
		this.claId = claId;
		this.claName = claName;
		this.stulist = stulist;
	}
	public int getClaId() {
		return claId;
	}
	public void setClaId(int claId) {
		this.claId = claId;
	}
	public String getClaName() {
		return claName;
	}
	public void setClaName(String claName) {
		this.claName = claName;
	}
	public ArrayList<Student> getStulist() {
		return stulist;
	}
	public void setStulist(ArrayList<Student> stulist) {
		this.stulist = stulist;
	}
	@Override
	public String toString() {
		return "Class [claId=" + claId + ", claName=" + claName + ", stulist=" + stulist + "]";
	}
	
}
