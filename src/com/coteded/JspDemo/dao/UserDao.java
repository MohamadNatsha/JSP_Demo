package com.coteded.JspDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.coteded.JspDemo.bo.UserBean;
import com.coteded.JspDemo.jooq.enums.UserAccounttype;
import com.coteded.JspDemo.jooq.tables.User;
import com.coteded.JspDemo.jooq.tables.records.UserRecord;
import com.coteded.JspDemo.service.ConnectionService;

public class UserDao {

	public void AddUser(UserBean userBean) throws SQLException, ClassNotFoundException {
		Connection conn = new ConnectionService().getConnection();
		try {
			DSLContext context = DSL.using(conn, SQLDialect.MYSQL);
			User user = new User();
			UserRecord userRecord = context.newRecord(user);
			userRecord.setName(userBean.getName());
			userRecord.setEmail(userBean.getEmail());
			userRecord.setDesc(userBean.getDesc());
			userRecord.setVideo(userBean.getVideo());
			userRecord.setImage(userBean.getImage());
			userRecord.setPhone(userBean.getPhone());
			userRecord.setAccounttype(userBean.getAccountType());
			userRecord.store();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public UserBean GetUser(String email) throws SQLException, ClassNotFoundException {
		Connection conn = new ConnectionService().getConnection();
		try {
			DSLContext context = DSL.using(conn, SQLDialect.MYSQL);
			User USER = User.USER;
			Result<UserRecord> userRecords = context.selectFrom(USER).where(USER.EMAIL.eq(email)).limit(1).fetch();

			if (userRecords.size() > 0) {
				UserRecord record = userRecords.get(0);
				UserBean userBean = new UserBean();
				// transform the record to a user bean
				userBean.setName(record.getName());
				userBean.setPhone(record.getPhone());
				userBean.setEmail(record.getEmail());
				userBean.setImage(record.getImage());
				userBean.setVideo(record.getVideo());
				userBean.setDesc(record.getDesc());
				userBean.setAccountType(record.getAccounttype());
				return userBean;
			}

			return null;

		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
