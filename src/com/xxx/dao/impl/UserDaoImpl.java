package com.xxx.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.sun.org.apache.xml.internal.security.utils.XMLUtils;
import com.sun.xml.internal.txw2.Document;
import com.xxx.dao.UserDao;
import com.xxx.domain.User;
import com.xxx.util.JDBCUtils;

public class UserDaoImpl implements UserDao {
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	public boolean insert(User user){		
		try{
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			//���Statement����
			stmt=conn.createStatement();
			//����SQL���
			//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			//String birthday=sdf.format(user.getbirthday);
			String sql="INSERT INTO users(user_id,username,password,email,sex,address,identity)"+"VALUES("+user.getUser_id()
					+",'"
					+user.getUsername()
					+"','"
					+user.getPassword()
					+"','"
					+user.getEmail()+"','"+user.getSex()+"','"+user.getAddress()+"','"+user.getIdentity()+"')";
			
			int num=stmt.executeUpdate(sql);
			
			if(num>0){
				return true;
			}
			return false;
					
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
		
	}
	
	public ArrayList<User>findAll(){		
		ArrayList<User>list=new ArrayList<User>();
		try{
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			//���Statement����
			stmt=conn.createStatement();
			//����SQL���
			String sql="SELECT * FROM users";
			
			rs=stmt.executeQuery(sql);
			
			//��������
			while(rs.next()){
				User user=new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				user.setIdentity(rs.getString("identity"));
				list.add(user);
			   }
			return list;
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
		return null;
	}
	
	public User find(int user_id){
		try{
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			//���Statem����
			stmt=conn.createStatement();
			//����SQL���
			String sql="SELECT * FROM users WHERE user_id="+user_id;
			rs=stmt.executeQuery(sql);
			//��������
			while(rs.next()){
				User user=new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				user.setIdentity(rs.getString("identity"));
				return user;
		
			}
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	public User find(String username,String password){
		try{
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			//���Statement����
			stmt=conn.createStatement();
			//����SQL���
			String sql="SELECT * FROM users WHERE username="+username+"&& password="+password;
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			
			//��������
			while(rs.next()){
				User user=new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				user.setIdentity(rs.getString("identity"));
				return user;
			}
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
		
		/*try{
			Document document=XMLUtils.getDocument();
			//ʹ��XPath���ʽ������XML�ڵ�
			Element e=(Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e==null){
				return null;
			}
			User user=new User();
			user.setUser_id(e.attributeValue("user_id"));
			user.setUsername(e.sttributeValue("username"));
			user.setPassword(e.attributeValue("password"));
			user.setEmail(e.attributeValue("email"));
			user.setSex(e.attributeValue("sex"));
			user.setAddress(e.attributeValue("address"));
			user.setIdentity(e.attirbuteValue("identity"));
			return user;
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}*/
	
	}
	
	public boolean delete(int user_id){
		try{
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			//���Statement����
			stmt=conn.createStatement();
			//����SQL���
			String sql="DELETE FROM users WHERE user_id="+user_id;
			int num=stmt.executeUpdate(sql);
			if(num>0){
				return true;
			}
			return false;
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
		return false;
	}
	
	public boolean update(User user){
		try{
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			//���Statement����
			stmt=conn.createStatement();
			//����SQL���
			String sql="UPDATE users set username='"+user.getUsername()+"',password='"+user.getPassword()+"',email='"+user.getEmail()
					+"',sex='"+user.getSex()+"',address='"+user.getAddress()+"',identity='"+user.getIdentity()+"'WHERE user_id="+user.getUser_id();
			int num=stmt.executeUpdate(sql);
			if(num>0){
				return true;
			}
			return false;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	  }

	}

