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
	
	private boolean idExist(int id, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT id FROM member WHERE id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		return rs.next(); 
	}
	
	@Override
	public void insertMember(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "INSERT INTO member(id,name,email,phone) VALUES(seq_id.NEXTVAL,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPhone());
			System.out.println(ps.executeUpdate()+" ROW INSERT OK");
		} finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public void deleteMember(int id) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(idExist(id, conn)) {
				String query = "DELETE member WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				System.out.println(ps.executeUpdate()+" ROW DELETE OK");
			} else {
				throw new RecordNotFoundException("Member is not found");
			}
		} finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void updateMember(Member member) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(idExist(member.getId(), conn)) {
				String query = "UPDATE member SET name=?,email=?,phone=? WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, member.getName());
				ps.setString(2, member.getEmail());
				ps.setString(3, member.getPhone());
				ps.setInt(4, member.getId());
				System.out.println(ps.executeUpdate()+" ROW UPDATE OK");
			} else {
				throw new RecordNotFoundException("Member is not found");
			}
		} finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public Member getMember(int id) throws SQLException, RecordNotFoundException {
		Member member = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			if(idExist(id, conn)) {
				String query = "SELECT * FROM member WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					member = new Member(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone"));
				}
			} else {
				throw new RecordNotFoundException("Member is not found");
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return member;
	}

	@Override
	public ArrayList<Member> getMember() throws SQLException {
		ArrayList<Member> member = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			String query = "SELECT * FROM member";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				member.add(new Member(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone")));
			}

		} finally {
			closeAll(conn, ps, rs);
		}
		return member;
	}

	@Override
	public ArrayList<Member> getMember(String name) throws SQLException {
		ArrayList<Member> member = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			String query = "SELECT * FROM member WHERE name=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				member.add(new Member(rs.getInt("id"),name,rs.getString("email"),rs.getString("phone")));
			}

		} finally {
			closeAll(conn, ps, rs);
		}
		return member;
	}
}
