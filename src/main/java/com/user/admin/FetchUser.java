package com.user.admin;

public class FetchUser{
	
	private int id;
	private String name;
	private String pass;
	private String email;
	
	public FetchUser(int id, String name, String pass, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
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
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "FetchUser [id=" + id + ", name=" + name + ", pass=" + pass + ", email=" + email + "]";
	}

}
