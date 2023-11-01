package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	static Connection conn;
//	public static Connection getConnection(){
//		
//		try {
//			
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://viaduct.proxy.rlwy.net:40926/railway","root","5cf5dD4cb3gBBBg1Ce5eD61bCdc4gcHG");
//			
//		} catch (Exception e) {
//			try {
//				conn.close();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		return conn;
//		
//	}
	
	
	public static Connection getConnection(){
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul","root","rahul");
		
	} catch (Exception e) {
		try {
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
	return conn;
	
}
	
	
}
