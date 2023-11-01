package com.user.admin;

public class FetchTransaction {
	private int id;
	private int f_id;
	private int t_id;
	private float amount;
	private  String C_date;
	
	
	public FetchTransaction(int id, int f_id, int t_id, float amount, String c_date) {
		super();
		this.id = id;
		this.f_id = f_id;
		this.t_id = t_id;
		this.amount = amount;
		C_date = c_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getC_date() {
		return C_date;
	}
	public void setC_date(String c_date) {
		C_date = c_date;
	}
	@Override
	public String toString() {
		return "FetchTransaction [id=" + id + ", f_id=" + f_id + ", t_id=" + t_id + ", amount=" + amount + ", C_date="
				+ C_date + "]";
	}
	
	
	
	

}
