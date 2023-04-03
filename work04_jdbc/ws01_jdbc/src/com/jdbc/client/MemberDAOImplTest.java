package com.jdbc.client;

import com.jdbc.dao.impl.MemberDAOImpl;
import com.jdbc.dto.Member;

public class MemberDAOImplTest {

	public static void main(String[] args) {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			dao.insertMember(new Member(0,"LEE","mail@mail.com","01012345678"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
}
