package com.xxx.junit;

import com.xxx.domain.User;
import com.xxx.dao.UserDao;
import com.xxx.dao.impl.UserDaoImpl;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDaoImpl ud=new UserDaoImpl();
		User user=new User();
		user.setUser_id(5);
		user.setUsername("abc");
		user.setPassword("123");
		user.setEmail("321");
		user.setSex("female");
		user.setAddress("ºþÀï");
		user.setIdentity("manager");
		boolean b=ud.insert(user);
		//System.out.println(b);

	}

}
