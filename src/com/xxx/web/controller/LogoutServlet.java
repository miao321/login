package com.xxx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

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

		//�Ƴ��洢��session�е�user����ʵ��ע������
		request.getSession().removeAttribute("user");
		//�����ַ����а��������ţ������������ʹ��MessageFormat��format����ƴ���ַ���ʱ�ͻ�������
		//MessageFormat��format����ֻ�ǰ��ַ����еĵ�����ȥ�������Ὣ������䵽ָ����ռλ����
		String tempStr=MessageFormat.format("ע���ɹ����������Ϊ���Զ�������¼ҳ�棡<meta http-equiv='refresh' content=';url={}'/>", 
				request.getContextPath()+"LoginUIServlet");
		System.out.println(tempStr);  //��������ע���ɹ��������Ϊ���Զ�������¼ҳ�棡����<meta http-equiv=refresh content=;url={}/>
		System.out.println("-------------------------------------------------------------------");
		/**
		 * Ҫ���������Ҫƴ�ӵ��ַ��������е����ţ���ôMessageFormat��format������ֻ�ǰ��ַ����еĵ�����ȥ�������Ὣ������䵽ָ����ռλ���С�������⣬
		 * ��ô������Ҫʹ�õ��������������ַ�����ʹ�ø������������������磺��<meta http-equiv=''refresh'' content='';url={}''/>��
		 * ����MessageFormat��format("<meta http-equiv=''refresh'' content='';url={}''/>","index.jsp")�Ϳ�����������
		 * <meta http-equiv=''refresh'' content='';url=index.jsp'//>
		 */
	//String tempStr=MessageFormat.format("ע���ɹ����������Ϊ���Զ�������¼ҳ�棡<meta http-equiv='refresh' content=';url={}'/>", 
		//		request.getContextPath()+"LoginUIServlet");
		
		String message=String.format("ע���ɹ����������Ϊ���Զ�������¼ҳ�棡<meta http-equiv='refresh' content=';url={}'/>", 
				request.getContextPath()+"LoginUIServlet");
		request.setAttribute("message",message);
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
