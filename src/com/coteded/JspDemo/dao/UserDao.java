package com.coteded.JspDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.coteded.JspDemo.bo.*;


public class UserDao {
	static String  userName = "root";
	static String  password = "admin";
	static String  url = "jdbc:mysql://local_host:3306/jsp_demo";
	
	public static UserInfo user;
	public static void AddUser(UserInfo user) throws SQLException{
		UserDao.user = user;
	}
	
	public static UserInfo GetUser() {
		return user;
	}
}
