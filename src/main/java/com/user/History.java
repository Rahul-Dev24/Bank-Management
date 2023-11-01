package com.user;

public class History {
	private String name;
	private String date;
	private String pay_type;
	private double amount;
	private String time;

	
	
	public History(String name,String date,String pay_type,double amount, String time){
		
		this.name = name;
		this.date = date;
		this.pay_type = pay_type;
		this.amount = amount;
		this.time = time;
		
//		this.rec_name = rec_name;
//		this.rec_amount = rec_amount;
//		this.rec_date = rec_date;
//		this.rec_pay_type = rec_pay_type;
		
	}



	@Override
	public String toString() {
		return "History [name=" + name + ", date=" + date + ", pay_type=" + pay_type + ", amount=" + amount + ", time="
				+ time + "]";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getPay_type() {
		return pay_type;
	}



	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}
	

}
