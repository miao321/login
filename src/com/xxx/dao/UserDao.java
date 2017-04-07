package com.xxx.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import sun.nio.cs.FastCharsetProvider;

import com.xxx.domain.User;
import com.xxx.util.JDBCUtils;

public interface UserDao {
	//添加用户操作
	public boolean insert(User user);
	
	//查询所有的User对象
	public ArrayList<User>findAll();
	
	//根据id查找指定的user
	public User find(int user_id);
	
	//根据用户名和密码来查找用户
	public User find(String username,String password);
	
	//删除用户
	public boolean delete(int user_id);
	 //修改用户
	public boolean update(User user);

	}


