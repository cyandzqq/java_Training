package com.capgemini.lessys.bean;

public class Schedule {

	private int id;
	private int teaId;
	private int lesId;
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Schedule(int id, int teaId, int lesId) {
		super();
		this.id = id;
		this.teaId = teaId;
		this.lesId = lesId;
	}
	public Schedule( int teaId, int lesId) {
		super();
		this.teaId = teaId;
		this.lesId = lesId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public int getLesId() {
		return lesId;
	}
	public void setLesId(int lesId) {
		this.lesId = lesId;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", teaId=" + teaId + ", lesId=" + lesId + "]";
	}
	
	
}
