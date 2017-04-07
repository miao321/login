package com.xxx.web.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author miao
 *��װ���û�ע���bean����������register��jsp�еı���������ֵ
 *RegisterFormBean����������register��jsp�еı��������name--��Ӧ
 *RegisterFormBean��ְ����˸������register��jsp�еı��������ֵ֮�⻹������У�Ա�����ֵ�ĺϷ���
 */

public class RegisterFormBean {
	//RegisterFormBean�е�������register��jsp�еı��������name--��Ӧ
	private String username;
	private String password;
	private String confirmPwd;
	private String email;
	private String sex;
	private String address;
	private String identity;
	
	/**
	 * �洢У�鲻ͨ��ʱ���û��Ĵ�����ʾ��Ϣ
	 */
	private Map<String, String> errors=new HashMap<String, String>();
	public Map<String, String> getErrors(){
		return errors;
	}
	public void setErrors(Map<String, String> errors){
		this.errors=errors;
	}
	/**
	 * validate��������У���������
	 * ��������У�����
	 * private String username; �û�������Ϊ�գ�����Ҫ��-����ĸ abcdABCD
	 * private String password; ���벻��Ϊ�գ�����Ҫ��-������
	 * private String confirmPwd; ȷ�����벻��Ϊ�գ�������������Ҫһ��
	 * private String email; ������Ϊ�ղ���Ҫ��һ���Ϸ�������
	 * private String sex; ����Ϊ�գ�Ϊ�л���Ů
	 * private String address; ����Ϊ��
	 * private String identity; ����Ϊ�ղ���ֻ�ܵ�manager����normal
	 * 
	 */
	public boolean validate(){
		boolean isOK=true;
		if(this.username==null||this.username.trim().equals("")){
			isOK=false;
			errors.put("username", "�û�������Ϊ��");
		}else{
			if(!this.username.matches("/^([A-Za-z]|[\u4E00-\u9FA5])+$/")){
				isOK=false;
				errors.put("username", "�û���������-λ����ĸ������");
			}
		}
		if(this.password==null||this.password.trim().equals("")){
			isOK=false;
			errors.put("password", "���벻��Ϊ�գ�����");
		}else{
			if(!this.password.matches("\\d+")){
				isOK=false;
				errors.put("password", "���������-λ���֣�����");
			}
		}
		if(this.confirmPwd==null||this.confirmPwd.trim().equals("")){
			isOK=false;
			errors.put("confirmPwd", "ȷ�����벻��Ϊ��");
		}else{
			if(this.confirmPwd!=null){
				if(!this.confirmPwd.equals(this.password)){
					isOK=false;
					errors.put("confirmPwd", "�������벻һ�£�����");
				}
			}
		}
		if(this.email==null||this.email.trim().equals("")){
			isOK=false;
			errors.put("email", "���䲻��Ϊ��");
		}else{
			if(this.email!=null&&!this.email.trim().equals("")){
				if(!this.email.matches("\\w+@\\W+(\\.\\w+)+")){
					isOK=false;
					errors.put("email", "���䲻��һ���Ϸ������䣡����");
				}
			}
		}
		if(this.sex==null||this.sex.trim().equals("")){
			isOK=false;
			errors.put("sex", "�Ա���Ϊ��");
		}
		if(this.address==null||this.address.trim().equals("")){
			isOK=false;
			errors.put("address", "��ַ����Ϊ��");
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
