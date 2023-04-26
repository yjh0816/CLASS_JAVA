package spring.service.user.impl;

import java.util.List;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;
	
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		return memberDAO.showAllMember();
	}

	@Override
	public String idExist(String id) throws Exception {
		return memberDAO.idExist(id);
	}
	

}
