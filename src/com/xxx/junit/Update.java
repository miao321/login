package com.xxx.junit;

import com.sun.jndi.url.ldaps.ldapsURLContextFactory;
import com.xxx.dao.impl.UserDaoImpl;
import com.xxx.domain.User;

public class Update {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//修改User对象的数据
		UserDaoImpl ud=new UserDaoImpl();
		User user=new User();
		user.setUser_id(3);
		user.setUsername("zhangsan");
		user.setPassword("abc");
		user.setEmail("77109@qq.com");
		user.setSex("male");
		user.setAddress("莞城");
		user.setIdentity("manager");
		boolean b=ud.update(user);

	}

}
