package com.jdbc.client;

import java.util.ArrayList;

import com.jdbc.dao.impl.MemberDAOImpl;
import com.jdbc.dto.Member;

import config.ServerInfo;

public class MemberDAOImplTest {

	public static void main(String[] args) {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
//			dao.insertMember(new Member("LEE","mail@mail.com","01012345678"));
//			dao.insertMember(new Member("LEE","mail2@mail.com","01011111111"));
//			dao.deleteMember(2);
//			dao.updateMember(new Member(1,"LEE","mail@mail.com","01055555555"));
//			System.out.println(dao.getMember(1));
//			ArrayList<Member> member = dao.getMember();
//			for(Member m : member) {
//				System.out.println(m);
//			}
			ArrayList<Member> member = dao.getMember("LEE");
			for(Member m : member) {
				System.out.println(m);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공..");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패..");
		}
	}
}
