package com.xxx.web.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author miao
 *封装的用户注册表单bean，用来接收register。jsp中的表单输入项是值
 *RegisterFormBean中是属性与register。jsp中的表单输入项的name--对应
 *RegisterFormBean的职责除了负责接收register。jsp中的表单输入项的值之外还担任着校对表单输入值的合法性
 */

public class RegisterFormBean {
	//RegisterFormBean中的属性与register。jsp中的表单输入项的name--对应
	private String username;
	private String password;
	private String confirmPwd;
	private String email;
	private String sex;
	private String address;
	private String identity;
	
	/**
	 * 存储校验不通过时给用户的错误提示信息
	 */
	private Map<String, String> errors=new HashMap<String, String>();
	public Map<String, String> getErrors(){
		return errors;
	}
	public void setErrors(Map<String, String> errors){
		this.errors=errors;
	}
	/**
	 * validate方法负责校验表单输入项
	 * 表单输入项校验规则
	 * private String username; 用户名不能为空，并且要是-的字母 abcdABCD
	 * private String password; 密码不能为空，并且要是-的数字
	 * private String confirmPwd; 确认密码不能为空，并且两次密码要一样
	 * private String email; 不可以为空并且要是一个合法的邮箱
	 * private String sex; 不能为空，为男或者女
	 * private String address; 不能为空
	 * private String identity; 可以为空并且只能的manager或者normal
	 * 
	 */
	public boolean validate(){
		boolean isOK=true;
		if(this.username==null||this.username.trim().equals("")){
			isOK=false;
			errors.put("username", "用户名不能为空");
		}else{
			if(!this.username.matches("/^([A-Za-z]|[\u4E00-\u9FA5])+$/")){
				isOK=false;
				errors.put("username", "用户名必须是-位的字母！！！");
			}
		}
		if(this.password==null||this.password.trim().equals("")){
			isOK=false;
			errors.put("password", "密码不能为空！！！");
		}else{
			if(!this.password.matches("\\d+")){
				isOK=false;
				errors.put("password", "密码必须是-位数字！！！");
			}
		}
		if(this.confirmPwd==null||this.confirmPwd.trim().equals("")){
			isOK=false;
			errors.put("confirmPwd", "确认密码不能为空");
		}else{
			if(this.confirmPwd!=null){
				if(!this.confirmPwd.equals(this.password)){
					isOK=false;
					errors.put("confirmPwd", "两次密码不一致！！！");
				}
			}
		}
		if(this.email==null||this.email.trim().equals("")){
			isOK=false;
			errors.put("email", "邮箱不能为空");
		}else{
			if(this.email!=null&&!this.email.trim().equals("")){
				if(!this.email.matches("\\w+@\\W+(\\.\\w+)+")){
					isOK=false;
					errors.put("email", "邮箱不是一个合法的邮箱！！！");
				}
			}
		}
		if(this.sex==null||this.sex.trim().equals("")){
			isOK=false;
			errors.put("sex", "性别不能为空");
		}
		if(this.address==null||this.address.trim().equals("")){
			isOK=false;
			errors.put("address", "地址不能为空");
		}
		return isOK;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	

}
