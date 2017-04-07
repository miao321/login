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
			//�����ڱ����쳣��ԭ��������һ�����������쳣���Ը��û�һ���Ѻ���ʾ
			//throw new UserException("ע����û��Ѿ����ڣ�����");
		}
		userDao.insert(user);
	}
	@Override
	public User loginUser(String username,String password){
		return userDao.find(username,password);
	}

}
