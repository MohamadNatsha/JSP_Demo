package com.coteded.JspDemo.dao;

import java.util.ArrayList;
import java.util.List;

import com.coteded.JspDemo.bo.*;


public class UserDao {
	
	public static List<UserInfo> users = new ArrayList<UserInfo>();
	public static void AddUser(UserInfo user){
		users.add(user);
	}
	
	public static void GetUser() {
		
	}
}
