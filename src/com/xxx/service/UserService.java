package com.xxx.service;

import org.omg.CORBA.UserException;

import com.xxx.domain.User;


public interface UserService {
	/**
	 * 提供注册服务
	 * @param user
	 * @throws UserExistException
	 */
	void registerUser(User user);
	/**
	 * 提供登录服务
	 * @param username
	 * @param password
	 * @return
	 */
	User loginUser(String username,String password);

}
