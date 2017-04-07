package com.xxx.util;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCUtils {
	//加载驱动，并建立数据库连接
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/demo";
		String username="root";
		String password="123456";
		Connection conn=DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	//关闭数据库连接，释放资源
	public static void release(Statement stmt,Connection conn){
		if(stmt!=null){
			try{
				stmt.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			stmt=null;
		}
		
		if(conn!=null){
			try{
				conn.close();
			}catch (SQLException e) {	
				// TODO: handle exception
				e.printStackTrace();
			}
			conn=null;
		}
	}
	
	public static void release(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try{
				rs.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			rs=null;
		}
		release(stmt, conn);
	}

}
