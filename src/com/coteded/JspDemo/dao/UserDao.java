package com.coteded.JspDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.coteded.JspDemo.jooq.enums.UserAccounttype;
import com.coteded.JspDemo.jooq.tables.User;
import com.coteded.JspDemo.jooq.tables.records.UserRecord;


public class UserDao {
	static String  userName = "root";
	static String  password = "Test1234";
	static String  url = "jdbc:mysql://localhost:3306/jsp_demo?serverTimezone=UTC";
	

	public static void AddUser(String name,UserAccounttype type,String phone,String email,String desc,String image,String video) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, userName, password);
		DSLContext context = DSL.using(conn, SQLDialect.MYSQL);
		
		User user = new User();
		UserRecord userRecord = context.newRecord(user).values(name,type,phone,email,desc,image,video);
		userRecord.store();
		
		System.out.println("user saved");
		
	}
	
	public static UserRecord GetUser(String email) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, userName, password);
		DSLContext context = DSL.using(conn, SQLDialect.MYSQL);
		
		User USER = User.USER;
		Result<UserRecord> userRecords = context.selectFrom(USER).where(USER.EMAIL.eq(email)).limit(1).fetch();
		if(userRecords.size() > 0)
			return userRecords.get(0);
		
		return null;
	}
}
