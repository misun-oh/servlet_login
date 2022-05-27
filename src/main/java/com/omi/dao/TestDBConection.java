package com.omi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBConection {
	
		
	private Statement stmt;
	private Connection con;
	
	/**
	 * DB ���� ����
	 */
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://cya-mysql-db-1.cghyotucbypl.ap-northeast-2.rds.amazonaws.com";
	private static final String user = "*";
	private static final String pwd = "*";
	
	/**
	 * DB�� �����ϰ� connection�� ���� �մϴ�.
	 */
	private void connDB() {
		try {
			// OracleDriver Ŭ���� ȣ�� -> ojdbc ���̺귯���� ���ٸ� ������ �߻�
			Class.forName(driver);
			System.out.println("mysql ����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
			stmt = con.createStatement();
			System.out.println("Statement ���� ����");
			
			System.out.println(stmt.execute("select 1 from dual "));
			// connection ���� ����
			con.close();
			System.out.println("Connection ���� ����");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ������ ���̽� ���� �׽�Ʈ
	 * �����غ��ô�
	 * @param args
	 */
	public static void main(String[] args) {
		TestDBConection test = new TestDBConection();
		test.connDB();
	}		
		
}
