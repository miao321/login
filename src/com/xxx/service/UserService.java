package com.xxx.service;

import org.omg.CORBA.UserException;

import com.xxx.domain.User;


public interface UserService {
	/**
	 * �ṩע�����
	 * @param user
	 * @throws UserExistException
	 */
	void registerUser(User user);
	/**
	 * �ṩ��¼����
	 * @param username
	 * @param password
	 * @return
	 */
	User loginUser(String username,String password);

}
