package com.xxx.junit;

import java.util.ArrayList;



import com.xxx.dao.impl.UserDaoImpl;
import com.xxx.domain.User;

public class SearchAll {
	public static void main(String[] args){
		UserDaoImpl ud=new UserDaoImpl();
		ArrayList<User>list=ud.findAll();
	
		for(int i=0;i<list.size();i++){
			System.out.println("��"+(i+1)+"�����ݵ�usernameֵΪ��"+list.get(i).getUsername());
		}
	}

}
