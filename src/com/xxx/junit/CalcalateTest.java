package com.xxx.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xxx.dao.impl.UserDaoImpl;
import com.xxx.domain.User;
import com.xxx.dao.*;
public class CalcalateTest {
	UserDaoImpl ud=new UserDaoImpl();
	User user=new User();
//	user.setUser_id(2);
//	user.setUsername("abc");
  	Calculate calculate=new Calculate();
	int sum=calculate.sum(2, 5);
	int testSum=7;
	
	@Test
	public void testSum(){
		System.out.println("@Test sum(): "+sum+"="+testSum);
		assertEquals(sum,testSum);
	}

}
