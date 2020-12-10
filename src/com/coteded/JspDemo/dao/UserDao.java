package com.coteded.JspDemo.dao;

import java.util.ArrayList;
import java.util.List;

import com.coteded.JspDemo.bo.*;


public class UserDao {
	
	public static UserInfo user;
	public static void AddUser(UserInfo user){
		UserDao.user = user;
	}
	
	public static UserInfo GetUser() {
		return user;
	}
}
