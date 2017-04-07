package com.xxx.junit;

import java.sql.Connection;

import java.sql.PreparedStatement;
import com.xxx.util.JDBCUtils;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement preStmt=null;
		try{
			//加载并注册数据库驱动
			conn=JDBCUtils.getConnection();
			String sql="INSERT INTO users(username,password,email,sex,address,identity)"+"VALUES(?,?,?,?,?,?)";
			preStmt=conn.prepareStatement(sql);
			for(int i=0;i<5;i++){
				preStmt.setString(1, "username"+i);
				preStmt.setString(2, "password"+i);
				preStmt.setString(3, "email"+i+"@itcast.cn");
				preStmt.setString(4, "sex"+i);
				preStmt.setString(5, "address"+i);
				preStmt.setString(6, "identity"+i);
				preStmt.addBatch();
				
			}
			preStmt.executeBatch();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				JDBCUtils.release(null, preStmt, conn);
			}
		}

	}

