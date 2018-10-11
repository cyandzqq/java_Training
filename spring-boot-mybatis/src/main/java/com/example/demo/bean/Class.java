package com.example.demo.bean;

import java.util.ArrayList;

public class Class {

	private int cla_id;
	private String cla_name;
	private ArrayList<Student> stulist;
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Class(int id, String name, ArrayList<Student> stulist) {
		super();
		this.cla_id = id;
		this.cla_name = name;
		this.stulist = stulist;
	}
	public int getId() {
		return cla_id;
	}
	public void setId(int id) {
		this.cla_id = id;
	}
	public String getName() {
		return cla_name;
	}
	public void setName(String name) {
		this.cla_name = name;
	}
	public ArrayList<Student> getStulist() {
		return stulist;
	}
	public void setStulist(ArrayList<Student> stulist) {
		this.stulist = stulist;
	}
	public void addStudent(Student stu){
		this.stulist.add(stu);
	}
	@Override
	public String toString() {
		return "Class [id=" + cla_id + ", name=" + cla_name + ", stulist=" + stulist + "]";
	}
	
	
}
