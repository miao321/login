package com.xxx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;


import com.xxx.domain.User;
import com.xxx.service.UserService;
import com.xxx.service.impl.UserServiceImpl;
import com.xxx.util.WebUtils;
import com.xxx.web.formbean.RegisterFormBean;

/**
 * 
 * @author miao
 *处理用户注册的servlet
 */

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//将客户提交的表单数据封装到RegisterFormBean对象中
		RegisterFormBean formbean=WebUtils.requestBean(request, RegisterFormBean.class);
		//校验用户注册填写的表单数据
		if(formbean.validate()==false){
			//如果校验失败，将封装了用户填写的表单数据的formbean对象发回register。jsp页面的form表单中进行显示
			request.setAttribute("formbean", formbean);
			//校验失败就说明是用户填写的表单数据有问题，那么就跳回register。jsp
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request,response);
			return;
		}
		User user=new User();
		try{
			//注册字符串到日期的转换器
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean); //把表单的数据填充到javabean中
			//user.setUser_id(WebUtils.makeId()); //设置用户的Id属性
			UserService service=new UserServiceImpl();
			//调用service层提供的注册用户服务实现用户注册
			service.registerUser(user);
			String message=String.format("注册成功！秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content=';url=%s'/>",request.getContextPath()+"LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			formbean.getErrors().put("username", "注册用户已存在！！！");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		}//catch (Exception e) {
			// TODO: handle exception
		//}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
