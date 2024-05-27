package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	
	public Connection getDBConnection(String url, String username, String password) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("url getting"+url);
			System.out.println("username getting"+username);
			System.out.println("password getting"+password);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niteendb","root",password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
