package com.xxx.junit;

import com.xxx.dao.impl.UserDaoImpl;
import com.xxx.domain.User;

public class SearchId {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDaoImpl ud=new UserDaoImpl();
		User user=ud.find("username", "password");
		System.out.println(user.getAddress());

	}

}
