package com.capgemini.lessys.bean;

public class Schedule2 {

	private int id;
	private int teaId;
	private String teaName;
	private int lesId;
	private String lesName;
	public Schedule2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Schedule2(int id, int teaId, String teaName, int lesId, String lesName) {
		super();
		this.id = id;
		this.teaId = teaId;
		this.teaName = teaName;
		this.lesId = lesId;
		this.lesName = lesName;
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
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public int getLesId() {
		return lesId;
	}
	public void setLesId(int lesId) {
		this.lesId = lesId;
	}
	public String getLesName() {
		return lesName;
	}
	public void setLesName(String lesName) {
		this.lesName = lesName;
	}
	@Override
	public String toString() {
		return "Schedule2 [id=" + id + ", teaId=" + teaId + ", teaName=" + teaName + ", lesId=" + lesId + ", lesName="
				+ lesName + "]";
	}
	
}
