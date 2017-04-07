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
 *�����û�ע���servlet
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

		//���ͻ��ύ�ı����ݷ�װ��RegisterFormBean������
		RegisterFormBean formbean=WebUtils.requestBean(request, RegisterFormBean.class);
		//У���û�ע����д�ı�����
		if(formbean.validate()==false){
			//���У��ʧ�ܣ�����װ���û���д�ı����ݵ�formbean���󷢻�register��jspҳ���form���н�����ʾ
			request.setAttribute("formbean", formbean);
			//У��ʧ�ܾ�˵�����û���д�ı����������⣬��ô������register��jsp
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request,response);
			return;
		}
		User user=new User();
		try{
			//ע���ַ��������ڵ�ת����
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean); //�ѱ���������䵽javabean��
			//user.setUser_id(WebUtils.makeId()); //�����û���Id����
			UserService service=new UserServiceImpl();
			//����service���ṩ��ע���û�����ʵ���û�ע��
			service.registerUser(user);
			String message=String.format("ע��ɹ������Ϊ���Զ�������¼ҳ�棡��<meta http-equiv='refresh' content=';url=%s'/>",request.getContextPath()+"LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			formbean.getErrors().put("username", "ע���û��Ѵ��ڣ�����");
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
