package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dao.MemberDAO;
import com.jdbc.dto.Member;
import com.jdbc.exception.DuplicateIDException;
import com.jdbc.exception.RecordNotFoundException;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl dao = new MemberDAOImpl();

	private MemberDAOImpl() {
	}
	
	public static MemberDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Connection....OK");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(conn, ps);
	}
	
	private boolean ssnExist(int id, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT id FROM member WHERE id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		return rs.next(); 
	}
	
	@Override
	public void insertMember(Member member) throws SQLException, DuplicateIDException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!ssnExist(member.getId(), conn)) {
				String query = "INSERT INTO member(id,name,email,phone) VALUES(seq_id.NEXTVAL,?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(2, member.getName());
				ps.setString(3, member.getEmail());
				ps.setString(4, member.getPhone());
				System.out.println(ps.executeUpdate()+" ROW INSERT OK");
			} else {
				throw new DuplicateIDException("Member is already exist");
			}
		} finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public void deleteMember(int id) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(Member member) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member getMember(int id) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Member> getMember() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Member> getMember(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
