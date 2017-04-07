package com.xxx.service.impl;

import org.omg.CORBA.UserException;


import com.xxx.dao.UserDao;
import com.xxx.dao.impl.UserDaoImpl;
import com.xxx.domain.User;
import com.xxx.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao=new UserDaoImpl();
	@Override
	public void registerUser(User user){
		if(userDao.find(user.getUser_id())!=null){
			//checked exception
			//unchecked exception
			//这里炮编译异常的原因：是想上一层程序处理这个异常，以给用户一个友好提示
			//throw new UserException("注册的用户已经存在！！！");
		}
		userDao.insert(user);
	}
	@Override
	public User loginUser(String username,String password){
		return userDao.find(username,password);
	}

}
