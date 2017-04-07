/*package com.xxx.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;




import javax.servlet.FilterChain;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;



public class EncodingFilter implements Filter {
	public void init(FilterConfig fileterConfig)throws ServletException{
		
	}
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
		//处理请求乱码
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpServletRequest myRequest=new MyRequest(httpServletRequest);
		//处理响应乱码
		response.setCharacterEncoding("text/html;charset=utf-8");
		chain.doFilter(myRequest, response);
	}
	public void destory(){
		
	}
}

//自定义request对象
class MyRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	private boolean hasEncode;
	public MyRequest(HttpServletRequest request){
		super(request);   //super必须写
		this.request=request;
	}
	//对需要增强方法进行覆盖
	@Override
	public Map getParameterMap(){
		//先获得请求方法
		String method=request.getMethod();
		if(method.equalsIgnoreCase("post")){
			//post处理
			try{
				//处理post乱码
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			}catch (UnsupportedEncodingException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else if(method.equalsIgnoreCase("get")){
			//get请求
			Map<String, String[]>parameterMap=request.getParameterMap();
			if(!hasEncode){
				//确保get手动编码逻辑只运行一次
				for(String parameterName:parameterMap.keySet()){
					String[] values=parameterMap.get(parameterName);
					if(values!=null){
						for(int i=0;i<values.length;i++){
							try{
								//处理get乱码
								values[i]=new String(values[i].getBytes("ISO-8859-1"),"utf-8");
							}catch (UnsupportedEncodingException e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
					}
				}
				hasEncode=true;
			}
			return parameterMap;
		}
		return super.getParameterMap();
	}
	@Override
	public  String getParameter(String name){
		Map<String, String[]>parameterMap=getParameterMap();
		String[] values=parameterMap.get(name);
		if(values==null){
			return null;
		}
		return values[0];  //取回参数 的第一个值
	}
	@Override
	public String[] getParameterValues(String name){
		Map<String, String[]>parameterMap=getParameterMap();
		String[] values=parameterMap.get(name);
		return values;
	}
	
}
*/