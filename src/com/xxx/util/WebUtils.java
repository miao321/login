package com.xxx.util;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * @author miao
 *��request�����е����������װ��bean��
 */

public class WebUtils {
	/**
	 * ��request����ת����T����
	 * @param request
	 * @param clazz
	 * @return
	 */
	
	public static <T> T requestBean(HttpServletRequest request,Class<T> clazz){
		try{
			T bean=clazz.newInstance();
			Enumeration<String> e=request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value=request.getParameter(name);
				BeanUtils.setProperty(bean,name,value);	
			}
			return bean;
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	/**
	 * ����UUID
	 * @return
	 */
	public static String makeId(){
		return UUID.randomUUID().toString();
	}

}
