package com.coteded.JspDemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.coteded.JspDemo.bo.UserBean;
import com.coteded.JspDemo.dao.UserDao;
import com.coteded.JspDemo.jooq.enums.UserAccounttype;
import com.coteded.JspDemo.jooq.tables.User;
import com.coteded.JspDemo.jooq.tables.records.UserRecord;

public class UserService {
	public void AddUser(UserBean userBean) throws SQLException, ClassNotFoundException {
		UserDao userDao = new UserDao();
		userDao.AddUser(userBean);
	}

	public UserBean GetUser(String email) throws SQLException, ClassNotFoundException {
		UserDao userDao = new UserDao();
		return userDao.GetUser(email);
	}
}
