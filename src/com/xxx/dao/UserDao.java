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
	//����û�����
	public boolean insert(User user);
	
	//��ѯ���е�User����
	public ArrayList<User>findAll();
	
	//����id����ָ����user
	public User find(int user_id);
	
	//�����û����������������û�
	public User find(String username,String password);
	
	//ɾ���û�
	public boolean delete(int user_id);
	 //�޸��û�
	public boolean update(User user);

	}


