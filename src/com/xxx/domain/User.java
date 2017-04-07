package com.xxx.domain;

public class User {
	private int user_id;
	private String username;
	private String password;
	private String email;
	private String sex;
	private String address;
	private String identity;
	
	public User(){
		super();
	}
	public User(int user_id,String username,String password,String email,String sex,String address,String identity){
		this.user_id=user_id;
		this.username=username;
		this.password=password;
		this.email=email;
		this.sex=sex;
		this.address=address;
		this.identity=identity;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
