package com.user;

public class RecDetails{

	private String rec_name;
	private double rec_amount;
	private String rec_pay_type;
	private String rec_date;
	
	public RecDetails(String rec_name, double rec_amount, String rec_pay_type, String rec_date) {
		super();
		this.rec_name = rec_name;
		this.rec_amount = rec_amount;
		this.rec_pay_type = rec_pay_type;
		this.rec_date = rec_date;
	}

	

	public String getRec_name() {
		return rec_name;
	}

	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}

	public double getRec_amount() {
		return rec_amount;
	}

	public void setRec_amount(double rec_amount) {
		this.rec_amount = rec_amount;
	}

	public String getRec_pay_type() {
		return rec_pay_type;
	}

	public void setRec_pay_type(String rec_pay_type) {
		this.rec_pay_type = rec_pay_type;
	}

	public String getRec_date() {
		return rec_date;
	}

	public void setRec_date(String rec_date) {
		this.rec_date = rec_date;
	}

	@Override
	public String toString() {
		return "RecDetails [rec_name=" + rec_name + ", rec_amount=" + rec_amount + ", rec_pay_type=" + rec_pay_type
				+ ", rec_date=" + rec_date + "]";
	}
	
	
	
	
	
}
