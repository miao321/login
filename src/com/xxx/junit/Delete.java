package com.xxx.junit;

import com.xxx.dao.impl.UserDaoImpl;

public class Delete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDaoImpl ud=new UserDaoImpl();
		boolean b=ud.delete(2);

	}

}
