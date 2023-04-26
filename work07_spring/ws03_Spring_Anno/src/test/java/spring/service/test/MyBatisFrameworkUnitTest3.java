package spring.service.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.MemberVO;
import spring.service.user.impl.MemberDAOImpl;
import spring.service.user.impl.MemberServiceImpl;

public class MyBatisFrameworkUnitTest3 {

	public static void main(String[] args) throws Exception{
		SqlSession session = null;
		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		
		session=factory.openSession();
		
		MemberDAOImpl dao = new MemberDAOImpl();
		dao.setSqlSession(session);
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		memberService.setMemberDAO(dao);
		
		MemberVO vo = new MemberVO("777", "123", "아이유", "여의도");
		
		//1.
//		System.out.println(":: 1. registerMember(INSERT)  ? "	+ dao.registerMember(vo) );
		
		//2.
//		vo.setName("아이유2");
//		System.out.println(":: 2. updateMember(UPDATE)  ? "+dao.updateMember(vo) );
		
		//3.
//		System.out.println(":: 3. deleteMember (DELETE)  ? "+dao.deleteMember(vo.getId()) );

		
		//4.
		System.out.println(":: 4. getMember(SELECT)  ? " + memberService.getMember("111") );
		
		//5.
		System.out.println(":: 5. showAllMember(SELECT)  ? ");
		TestUtil.printList( memberService.showAllMember() );
		
		//6.
		System.out.println(":: 6. idExist(SELECT)  ? "+ memberService.idExist("111"));
		
	}

}










