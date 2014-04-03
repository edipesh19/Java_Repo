package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Main {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");
			conn.setAutoCommit(false);
			System.out.println(conn);
			stmt = conn.createStatement();
			System.out.println(stmt);
			String sql = "select * from patientinfo";
			rs = stmt.executeQuery(sql);
			rs.getMetaData();
			while(rs.next()){
				System.out.println(rs.getString("firstname"));
				System.out.println(rs.getString(5));
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				if(conn != null)
					conn.close();
				if(stmt != null)
					stmt.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				
			}
		}
		//update();
		updatePrepare();
	}

	public static void update(){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");
			System.out.println(conn);
			stmt = conn.createStatement();
			System.out.println(stmt);
			String sql = "update patientinfo set active='N' where firstname='John'";
			int i = stmt.executeUpdate(sql);
			System.out.println("record affected "+i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn != null)
					conn.close();
				if(stmt != null)
					stmt.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	public static void updatePrepare(){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");
			conn.getMetaData();
			
		/*	CallableStatement cstmt = conn.prepareCall("{call call_proc(?,?,?,?)}");
			cstmt.setString(1, "ss");
			cstmt.setString(2, "ss");
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.setString(4, "ss");
			cstmt.registerOutParameter(4, Types.VARCHAR);
			
			cstmt.execute();
			
			cstmt.getString(3);
			cstmt.getString(4);
			
			*/
			System.out.println(conn);
			String sql = "update patientinfo set active='N' where firstname= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "sathish");
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println("record affected "+i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn != null)
					conn.close();
				if(stmt != null)
					stmt.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	
	
	
	
	
}
