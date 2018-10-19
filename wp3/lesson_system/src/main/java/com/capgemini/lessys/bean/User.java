package com.capgemini.lessys.bean;

/*用户实体类*/
public class User {

	private int id;
	private String name;
	private String password;
	private String email;
	private int status;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String password, String email, int status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.status = status;
	}
	public User( String name, String password, String email, int status) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.status = status;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", status="
				+ status + "]";
	}
}
