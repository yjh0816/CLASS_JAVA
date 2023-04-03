package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectTest2 {
	public static void main(String[] args) {
		try {
			//1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. Driver Loading....Success...");
			
			//2. 디비연결...Connection반환
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kb_db", "1234");
			System.out.println("2. Driver Connect....Success...");
			//3. PreparedStatement 객체 생성..이때 인자값으로 쿼리문 입력(delete..333삭제)
//			String query = "DELETE custom WHERE id=?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setInt(1, 333);
//			System.out.println("3. PreparedStatement...");
//			
//			//4. 쿼리문 실행
//			System.out.println(ps.executeUpdate()+" ROW DELETE !!!");
			
			//UPDATE
//			String query = "UPDATE custom SET address=? WHERE id=?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, "뉴욕");
//			ps.setInt(2, 111);
//			System.out.println(ps.executeUpdate()+" ROW UPDATE !!!");
			
			//SELECT
			String query = "SELECT id,name,address FROM custom";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while(rs.next()) { //row 데이터가 있을때까지 실행
				System.out.println(rs.getInt("id")+"\t"
								  +rs.getString("name")+"\t"
								  +rs.getString("address"));
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("1. Driver Loading....Fail...");
		} catch (SQLException e) {
			System.out.println("2. Driver Connect....Fail...");
		}
		
		
//		
	}

}
