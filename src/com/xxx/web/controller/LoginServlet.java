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
 *�����û���¼��servlet
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
		//��ȡ�û���д�ĵ�¼�û���
		String username=request.getParameter("username");
		//��ȡ�û���д�ĵ�¼����
		String password=request.getParameter("password");
		UserService service=new UserServiceImpl();
		//�û���¼
		User user=service.loginUser(username, password);
		
		if(user==null){
			String message=String.format("�Բ����û��������������������µ�¼�� ���Ϊ���Զ�������¼ҳ�棡�� <meta http-equiv='refresh' content='3000';url='%s'>",
					request.getContextPath()+"LoginUIServlet");
			request.setAttribute("message", message);
			//System.out.println(message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//��¼�ɹ��󣬾ͽ��û��洢��session��
		request.getSession().setAttribute("user", user);
		String message=String.format("��ϲ��%s����¼�ɹ�����ҳ���� ���������ҳ������<meta http-equiv='refresh' content='3000';url='%s'>", user.getUsername(), request.getContextPath()+"/index.jsp");
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
