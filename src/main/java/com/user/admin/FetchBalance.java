package com.user.admin;

public class FetchBalance{
	
	private int id;
	private String name;
	private int t_id;
	private double balance;
	
	public FetchBalance(int id, String name, int t_id, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.t_id = t_id;
		this.balance = balance;
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

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "FetchBalance [id=" + id + ", name=" + name + ", t_id=" + t_id + ", balance=" + balance + "]";
	}
	
	
	
	
	

}
