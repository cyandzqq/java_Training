package com.capgemini.lessys.bean;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class Apply {

	private int id;
	private int stuId;
	private int stuNum;
	private String grade;
	private int lesId;
	private int teaId;
	private int masId;
	private String phone;
	private String email;
	private int stateOne;
	private int stateTwo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date timesubmit;
	
	private String stuName;
	private String lesName;
	private String teaName;
	private String masName;
	public Apply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Apply(int id, int stuId, int stuNum, String grade, int lesId, int teaId, int masId, String phone,
			String email, int stateOne, int stateTwo, String stuName, String lesName, String teaName,
			String masName, Date timesubmit) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.stuNum = stuNum;
		this.grade = grade;
		this.lesId = lesId;
		this.teaId = teaId;
		this.masId = masId;
		this.phone = phone;
		this.email = email;
		this.stateOne = stateOne;
		this.stateTwo = stateTwo;
		this.timesubmit = timesubmit;
		this.stuName = stuName;
		this.lesName = lesName;
		this.teaName = teaName;
		this.masName = masName;
	}


	

	public Apply( int stuId, int stuNum, String grade, int lesId, int teaId, int masId, String phone,
			String email, Date timesubmit) {
		super();
		this.stuId = stuId;
		this.stuNum = stuNum;
		this.grade = grade;
		this.lesId = lesId;
		this.teaId = teaId;
		this.masId = masId;
		this.phone = phone;
		this.email = email;
		this.timesubmit = timesubmit;
	}
	
	public int getStateOne() {
		return stateOne;
	}

	public void setStateOne(int stateOne) {
		this.stateOne = stateOne;
	}


	public int getStateTwo() {
		return stateTwo;
	}


	public void setStateTwo(int stateTwo) {
		this.stateTwo = stateTwo;
	}


	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getLesName() {
		return lesName;
	}


	public void setLesName(String lesName) {
		this.lesName = lesName;
	}


	public String getTeaName() {
		return teaName;
	}


	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}


	public String getMasName() {
		return masName;
	}


	public void setMasName(String masName) {
		this.masName = masName;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getLesId() {
		return lesId;
	}
	public void setLesId(int lesId) {
		this.lesId = lesId;
	}
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public int getMasId() {
		return masId;
	}
	public void setMasId(int masId) {
		this.masId = masId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTimesubmit() {
		return timesubmit;
	}
	public void setTimesubmit(Date timesubmit) {
		this.timesubmit = timesubmit;
	}
	@Override
	public String toString() {
		return "Apply [id=" + id + ", stuId=" + stuId + ", stuNum=" + stuNum + ", grade=" + grade + ", lesId=" + lesId
				+ ", teaId=" + teaId + ", masId=" + masId + ", phone=" + phone + ", email=" + email + ", timesubmit="
				+ timesubmit + "]";
	}
	
	
}
