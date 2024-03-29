package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dto.Member;
import com.jdbc.exception.DuplicateIDException;
import com.jdbc.exception.RecordNotFoundException;

public interface MemberDAO {
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;
	void insertMember(Member member) throws SQLException, DuplicateIDException;
	void deleteMember(int id) throws SQLException, RecordNotFoundException;
	void updateMember(Member member) throws SQLException, RecordNotFoundException;
	Member getMember(int id) throws SQLException, RecordNotFoundException;
	ArrayList<Member> getMember() throws SQLException;
	ArrayList<Member> getMember(String name) throws SQLException;
}
