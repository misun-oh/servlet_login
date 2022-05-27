package com.omi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBConection {
	
		
	private Statement stmt;
	private Connection con;
	
	/**
	 * DB 접속 정보
	 */
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://cya-mysql-db-1.cghyotucbypl.ap-northeast-2.rds.amazonaws.com";
	private static final String user = "*";
	private static final String pwd = "*";
	
	/**
	 * DB에 연결하고 connection을 생성 합니다.
	 */
	private void connDB() {
		try {
			// OracleDriver 클래스 호출 -> ojdbc 라이브러리가 없다면 오류가 발생
			Class.forName(driver);
			System.out.println("mysql 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");
			
			System.out.println(stmt.execute("select 1 from dual "));
			// connection 연결 종료
			con.close();
			System.out.println("Connection 연결 종료");
			
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
	 * 데이터 베이스 접속 테스트
	 * 실행해봅시다
	 * @param args
	 */
	public static void main(String[] args) {
		TestDBConection test = new TestDBConection();
		test.connDB();
	}		
		
}
