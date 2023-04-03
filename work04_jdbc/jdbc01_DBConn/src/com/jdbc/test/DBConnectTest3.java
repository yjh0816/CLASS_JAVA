package com.jdbc.test;
/*
  디비연결 프로그램에 서버정보에 관련된 실제값이 하드코딩 되어져있다.
  드라이버  FQCN
  서버 주소, 계정 이름, 비번
   |
   |
   Meta Data 화(파일(xml, properties)로 분리)
   ::
   1. 드라이버 로딩
   2. 디비연결 ------------- Connection
   3. PreparedStatement - PreparedStatement
   4. 쿼리문 실행 ----------- ResultSet
   -----------------------------------------
   5. 자원반환..close()
      열린 순서 반대로 받는다.
      반드시 닫아야 한다....try~finally
      ResultSet
      PreparedStatement
      Connection
   
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectTest3 {
	public DBConnectTest3() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. Driver Loading....Success...");
			
			//2. 디비연결...Connection반환
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
			System.out.println("2. Driver Connect....Success...");
			
			//3. PreparedStatement 생성
			String query = "SELECT id,name,address FROM custom";
			ps = conn.prepareStatement(query);
			
			//4. 쿼리문 실행
			rs = ps.executeQuery(query);
			while(rs.next()) { //row 데이터가 있을때까지 실행
				System.out.println(rs.getInt("id")+"\t"
								  +rs.getString("name")+"\t"
								  +rs.getString("address"));
			}//while
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}//생성자
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DBConnectTest3();
	}//main

}//class