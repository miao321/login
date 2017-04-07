package com.xxx.web.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxx.domain.User;
import com.xxx.service.UserService;
import com.xxx.service.impl.UserServiceImpl;

/**
 * 
 * @author miao
 *处理用户登录的servlet
 */
public class LoginServlet extends HttpServlet {

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
		//获取用户填写的登录用户名
		String username=request.getParameter("username");
		//获取用户填写的登录密码
		String password=request.getParameter("password");
		UserService service=new UserServiceImpl();
		//用户登录
		User user=service.loginUser(username, password);
		
		if(user==null){
			String message=String.format("对不起，用户名或者密码有误！请重新登录！ 秒后为您自动跳到登录页面！！ <meta http-equiv='refresh' content='3000';url='%s'>",
					request.getContextPath()+"LoginUIServlet");
			request.setAttribute("message", message);
			//System.out.println(message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//登录成功后，就将用户存储到session中
		request.getSession().setAttribute("user", user);
		String message=String.format("恭喜：%s，登录成功！本页将在 秒后跳到首页！！！<meta http-equiv='refresh' content='3000';url='%s'>", user.getUsername(), request.getContextPath()+"/index.jsp");
		request.setAttribute("message", message);
		//System.out.println(message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);

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
