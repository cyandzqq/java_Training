package com.capgemini.lessys.bean;

import java.util.List;

/*课程实体类*/
public class Lesson {

	private int id;
	private String name;
	private List<User> tealist;
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lesson(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Lesson(int id, String name, List<User> tealist) {
		super();
		this.id = id;
		this.name = name;
		this.tealist = tealist;
	}
	
	public List<User> getTealist() {
		return tealist;
	}
	public void setTealist(List<User> tealist) {
		this.tealist = tealist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Lesson [id=" + id + ", name=" + name + ", tealist=" + tealist + "]";
	}
	
	
}
