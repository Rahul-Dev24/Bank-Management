package com.user;

public class User {

	private static int id;
	private static String name;
	private static String email;
	private static double balance;
	
//	public User(int id,String name,String email) {
//		this.id = id;
//		this.name = name;
//		this.email = email;
//	}
	
	public static double getBalance() {
		return balance;
	}
	public static void setBalance(double balance) {
		User.balance = balance;
	}
	public static int getId() {
		return id;
	}
	public void setId(int id) {
		User.id = id;
	}
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		User.name = name;
	}
	public static String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		User.email = email;
	}
	
	
	
}
