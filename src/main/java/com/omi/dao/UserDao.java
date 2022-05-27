package com.omi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.omi.dto.UserDto;

public class UserDao {
	
	private Statement stmt;
	private PreparedStatement prestmt;
	private Connection con;
	
	/**
	 * DB ���� ����
	 */
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@220.86.83.22:65065/ebiz";
	private static final String user = "cre_adm";
	private static final String pwd = "cresoty";
	
	/**
	 * DB�� �����ϰ� connection�� ���� �մϴ�.
	 */
	private void connDB() {
		try {
			// OracleDriver Ŭ���� ȣ�� -> ojdbc ���̺귯���� ���ٸ� ������ �߻�
			Class.forName(driver);
			System.out.println("Oracle ����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
			stmt = con.createStatement();
			System.out.println("Statement ���� ����");
			
			con.close();
			System.out.println(con.isClosed());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ������ ���̽� ���� �׽�Ʈ
	 * �����غ��ô�
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		//dao.connDB();
		
		UserDto userDto = new UserDto();
		userDto.setId("0001");
		userDto.setPw("1111");
		
		dao.login(userDto);
	}
	
	public UserDto login(UserDto userDto) {
		UserDto loginDto = new UserDto();
		try {
			// OracleDriver Ŭ���� ȣ�� -> ojdbc ���̺귯���� ���ٸ� ������ �߻�
			Class.forName(driver);
			System.out.println("Oracle ����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
			
			
			String sql = "select emp_id id, emp_name name from bill_employee where emp_id=? and passwd =?";
			
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, userDto.getId());
			prestmt.setString(2, userDto.getPw());
			
			// ���� ����
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				
				loginDto.setId(id);
				loginDto.setName(name);
			}
			System.out.println("id :" + loginDto.getId());
			System.out.println("name :" + loginDto.getName());
			con.close();
			System.out.println(con.isClosed());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(!con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return loginDto;
	}
}
