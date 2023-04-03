package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 
 디비 연결한 후 데이터를 추가, 삭제, 수정, 반환하는 작업을 하기 위해서는
 1. 드라이버를 메모리(DBConnectTest1.java가 실행되는 메모리)에 로딩..
 	Class.forName("드라이버명");
 2. 디비연결
 
 */
public class DBConnectTest1 {
	public static void main(String[] args) {
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. Driver Loading....Success...");
			
			//2. 디비연결..1)DB서버주소 2)계정 3)비밀번호
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kb_db", "1234");
			System.out.println("2. Driver Connect....Success...");
			
			//3. CRUD작업....디비서버와 연결이 이뤄져여만 가능....
			//PreparedStatement 객체 생성
			String query = "INSERT INTO custom(id, name, address) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query); //ps, pstmt
			System.out.println("3. PreparedStatement..Creating..");
			
			//?에 대한 값 바인딩
			ps.setInt(1, 333);
			ps.setString(2, "이정재");
			ps.setString(3, "신사동");
			
			System.out.println("\n=================INSERT================");
			//진짜 쿼리문이 실행...executeUpdate()
			System.out.println(ps.executeUpdate()+" row INSERT OK~~!!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("1. Driver Loading....Fail...");
		} catch (SQLException e) {
			System.out.println("2. Driver Connect....Fail...");
		}
		
		
//		
	}

}
