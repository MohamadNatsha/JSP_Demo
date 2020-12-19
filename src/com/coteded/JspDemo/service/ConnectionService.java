package com.coteded.JspDemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
	private static String userName = "root";
	private static String password = "Test1234";
	private static String url = "jdbc:mysql://localhost:3306/jsp_demo?serverTimezone=UTC&useSSL=false";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}

	public static void setUserName(String userName) {
		ConnectionService.userName = userName;
	}

	public static void setPassword(String password) {
		ConnectionService.password = password;
	}

	public static void setUrl(String url) {
		ConnectionService.url = url;
	}
}
