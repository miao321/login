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
		//�޸�User���������
		UserDaoImpl ud=new UserDaoImpl();
		User user=new User();
		user.setUser_id(3);
		user.setUsername("zhangsan");
		user.setPassword("abc");
		user.setEmail("77109@qq.com");
		user.setSex("male");
		user.setAddress("ݸ��");
		user.setIdentity("manager");
		boolean b=ud.update(user);

	}

}
