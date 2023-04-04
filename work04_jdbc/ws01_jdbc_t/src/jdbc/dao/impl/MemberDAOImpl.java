package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.MemberDAO;
import jdbc.dto.Member;
import jdbc.exception.DuplicateIDException;
import jdbc.exception.RecordNotFoundException;

public class MemberDAOImpl implements MemberDAO{
	
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		System.out.println("DAO Instance Creating....Using Singltone");
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	////////////////   공통적인 로직 ////////////////////////////////////////
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn=DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Server Connection......");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null) ps.close();
		if(conn !=null) conn.close();
		
	}
	
	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(conn,ps);	
		
	}
	//////////////////////// Business Logic //////////////////////////////
	private boolean idExist(int ssn,  Connection conn) throws SQLException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
//		boolean flag = false;	
			
		String query ="SELECT id FROM Member WHERE id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, ssn);
		rs = ps.executeQuery();	
		
		return rs.next();
	}
	

	@Override
	public void insertMember(Member dto) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "INSERT INTO member(id, name, email, phone) VALUES(seq_id.NEXTVAL,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getPhone());
			System.out.println(ps.executeUpdate()+" ROW INSERT OK");
						
		}finally {
			closeAll(conn, ps);
		}		
	}

//	@Override
//	public void deleteMember(int id) throws SQLException, RecordNotFoundException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		try {
//			conn = getConnect();
//			if(idExist(id, conn)) {
//				String query = "DELETE member WHERE id=?";
//				ps = conn.prepareStatement(query);
//				ps.setInt(1, id);
//				System.out.println(ps.executeUpdate()+" ROW DELETE OK");
//			} else {
//				throw new RecordNotFoundException("No such a member");
//			}
//		}finally {
//			closeAll(conn, ps);
//		}
//		
//	}

	@Override
	public void deleteMember(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "DELETE member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if(row<1) //throw new RecordNotFoundException("No such a member");
				System.out.println("No such a member");
//			System.out.println(row+" ROW DELETE OK");
		}finally {
			closeAll(conn, ps);
		}
		
	}
	
	@Override
	public void updateMember(Member dto) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			
			
			
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public Member getMember(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = getConnect();
			String query = "SELECT id, name, email, address FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) member = new Member(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("address"));
		}finally {
			closeAll(conn, ps, rs);
		}
		return member;
	}

	@Override
	public ArrayList<Member> getMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Member> members = new ArrayList<>();
		try {
			conn = getConnect();
			String query = "SELECT id, name, email, phone FROM member";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				members.add(new Member(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone")));
			}
					
		}finally {
			closeAll(conn, ps, rs);
		}
		return members;
	}

	@Override
	public ArrayList<Member> getMember(String address) throws SQLException {
		
		return null;
	}

}
